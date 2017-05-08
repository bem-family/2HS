package com.bem.web;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;

import com.bem.domain.LocalAuth;
import com.bem.domain.User;
import com.bem.service.UserService;

public abstract class BaseController {

	@Resource
	private UserService userService;
	
	public String getCurrentUsername() {
	      return SecurityContextHolder.getContext().getAuthentication().getName();
	   }
	
	public User getCurrentUser(){
		boolean userExists = (userService.findUserByAccount(getCurrentUsername()) == null);
		if(userExists){
			return null;
		}
		return userService.findUserByAccount(getCurrentUsername()).getUser();
	}
	
}
