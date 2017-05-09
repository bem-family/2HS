package com.bem.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bem.domain.TaskDto;
import com.bem.service.TaskService;


@Controller
public class IndexController {

	@Resource
	private TaskService taskService;
	
	protected String sessuserid = "";
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	//新增一条首页信息
	@PostMapping("/taskCreate")
	public String create(TaskDto taskCreateForm) {
		taskService.save(sessuserid,taskCreateForm);
		return "index";
	}
}
