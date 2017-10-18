package com.bem.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bem.domain.Task;
import com.bem.domain.UserDto;
import com.bem.repository.TaskRepository;
import com.bem.repository.UserRepository;
import com.bem.service.TaskService;
import com.bem.service.UserService;
import com.bem.utils.MyPage;

@Controller
public class UserController extends BaseController {
	
	@Resource
	private UserRepository userRepository;
	@Resource
	private TaskService taskService;
	@Resource
	private UserService userService;
	@Resource
	private TaskRepository taskRepository;
	
	@RequestMapping("/user")
	public String user(Model model){
		model.addAttribute("user",getCurrentUser());
		return "user";
	}
	@ResponseBody
	@RequestMapping("/user/remove/")
	public void remove(String string){
		taskService.remove(string,getCurrentUser());
	}
	
	
	@RequestMapping("/user/update/")
	public String update(UserDto Dto){
		userService.update(Dto,getCurrentUser());
		return "user";
	}
	
	@RequestMapping("/myrelease")
	public String release(Model model){
		MyPage<Task> pages = taskRepository.findByPageId(getCurrentUser().getId());
		model.addAttribute("user",getCurrentUser());
		model.addAttribute("pages",pages);
		return "user_myrelease";
	}
	@RequestMapping("/mycollect")
	public String collect(Model model){
		MyPage<Task> pages = taskRepository.findByPageId(getCurrentUser().getId());
		model.addAttribute("user",getCurrentUser());
		model.addAttribute("pages",pages);
		return "user_mycollect";
	}
	
}
