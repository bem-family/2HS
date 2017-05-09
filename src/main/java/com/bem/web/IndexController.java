package com.bem.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bem.domain.TaskCreateForm;
import com.bem.domain.TaskRepository;
import com.bem.service.TaskService;


@Controller
public class IndexController {

	@Resource
	private TaskService taskService;
	
	protected String sessuserid = "";
	
	
	@RequestMapping("/")
	public String index(Model model){
		List mlist = taskService.findAll();
		model.addAttribute("list", mlist);
		return "index";
	}
	
	
	
	@PostMapping("/task")
	public String index(TaskCreateForm taskCreateForm) {
		taskService.save(sessuserid,taskCreateForm);
		return "index";
	}
}
