package com.bem.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bem.Application;
import com.bem.domain.LocalAuth;
import com.bem.domain.TaskCreateForm;
import com.bem.domain.TaskRepository;
import com.bem.domain.User;
import com.bem.service.TaskService;
import com.bem.service.UserService;


@Controller
public class IndexController extends BaseController{
	
	@Resource
	private TaskService taskService;
	
	protected String sessuserid = "";
	
	@RequestMapping("/")
	public String index(){
		User user = getCurrentUser();
		return "index";
	}
	
	@PostMapping("/task")
	public String index(TaskCreateForm taskCreateForm) {
		taskService.save(sessuserid,taskCreateForm);
		return "index";
	}
}
