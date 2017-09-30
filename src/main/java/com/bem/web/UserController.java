package com.bem.web;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bem.domain.Task;
import com.bem.domain.User;
import com.bem.repository.TaskRepository;
import com.bem.repository.UserRepository;
import com.bem.utils.MyPage;

@Controller
public class UserController extends BaseController {
	
	@Resource
	private UserRepository userRepository;
	
	@Resource
	private TaskRepository taskRepository;
	
	@RequestMapping("/user")
	public String user(String userId,Model model){
		//User user = userRepository.findUserByUserId(userId);
		//model.addAttribute("user",user);
		return "user";
	}
	
	@RequestMapping("/user/update/")
	public String update(){
		return "redirect:/user";
	}
	
	@RequestMapping("/myrelease")
	public String release(String userId,Model model){
		MyPage<Task> pages = taskRepository.findByPageId(userId);
		model.addAttribute("pages",pages);
		return "user_myrelease";
	}
	@RequestMapping("/mycollect")
	public String collect(Model model){
		MyPage<Task> pages = taskRepository.findByPageId(getCurrentUser().getId());
		model.addAttribute("pages",pages);
		return "user_mycollect";
	}
	
}
