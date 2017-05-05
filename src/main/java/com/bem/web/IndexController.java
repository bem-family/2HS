package com.bem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bem.domain.TaskCreateForm;
import com.bem.service.TaskService;


@Controller
public class IndexController {

	@Autowired
	private TaskService taskService;
	
	protected String sessuserid = "";
	
	@PostMapping("/task")
	@ResponseBody
	public String index(TaskCreateForm taskCreateForm) {
		taskService.save(sessuserid,taskCreateForm);
		return "index";
	}
}
