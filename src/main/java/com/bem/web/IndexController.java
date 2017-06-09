package com.bem.web;


import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.bem.domain.QuizDto;
import com.bem.domain.QuizDtoWrapper;
import com.bem.domain.Task;
import com.bem.domain.TaskDto;
import com.bem.domain.User;
import com.bem.domain.User.ROLE;
import com.bem.service.QuizService;
import com.bem.service.TaskService;
import com.bem.service.UserService;

@Controller
public class IndexController extends BaseController{

	@Resource
	private TaskService taskService;
	
	@Resource
	private QuizService quizService;
	
	@Resource
	private UserService userService;
	
	protected String sessuserid = "";
	
	@RequestMapping("/")
	public String index(Model model){
		List<Task> mlist = taskService.findAll();
		model.addAttribute("list", mlist);
		return "index";
	}

	@GetMapping("/403")
    public String forbidden(){
        return "403";
    }
	
	@PreAuthorize("hasAnyAuthority('USER')")
	@GetMapping("/newPage")
	public String newpage(){
		return "new";
	}
	
	//新增一条首页信息

	@PostMapping("/taskCreate")
	public String addTask(TaskDto taskCreateForm) {
		taskService.save(getCurrentUser().getId(),taskCreateForm);
		return "index";
	}
	
	@GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable String id){
		taskService.delete(id);
		return "index";
	}
	@PostMapping("/update/{id}")
	public String update(TaskDto taskCreateForm,@PathVariable String id) {
		taskService.update(taskCreateForm, id);
		return "index";
	}
	
	@PostMapping("/checkAnswer")
	@ResponseBody
	public String checkAnswer(@RequestBody QuizDtoWrapper quizDto){
		String answers = quizDto.getan();
		String[] answer = answers.split("\\|");
		for(QuizDto attribute : quizDto.getQuizDto()) {
			  System.out.println(attribute.getQuestion());
		}
		if (quizService.checkAnswers(answer,quizDto)){
			User user = getCurrentUser();
			user.setRole(ROLE.USER);
			userService.updateUser(user);
			List<SimpleGrantedAuthority> authList=new ArrayList<SimpleGrantedAuthority>();
			authList.add(new SimpleGrantedAuthority("USER"));
			SecurityContext context=SecurityContextHolder.getContext();
			UserDetails userDetails=(UserDetails) context.getAuthentication().getPrincipal();
			Authentication auth=new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),authList);
			context.setAuthentication(auth); 
			return "success";
		}else{
			return "fail";
		}
		
	}
	
	//认证问题
	@PostMapping("/getQuizs")
	@ResponseBody
	public String getQuizs(){
		List<QuizDto> quizs = quizService.getRandom();
		String jsonQuizs = JSON.toJSONString(quizs);
		return jsonQuizs;
	}
}
