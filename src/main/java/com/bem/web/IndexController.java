package com.bem.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bem.domain.TaskCreateForm;
import com.bem.domain.TaskRepository;
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
	public String create(TaskCreateForm taskCreateForm) {
		taskService.save(sessuserid,taskCreateForm);
		return "index";
	}
}
