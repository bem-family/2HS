package com.bem.web;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bem.domain.User;
import com.bem.repository.UserRepository;

@Controller
public class UserController {
	
	@Resource
	private UserRepository userRepository;
	
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
}
