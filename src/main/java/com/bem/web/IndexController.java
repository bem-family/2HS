package com.bem.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bem.domain.TaskCreateForm;
import com.bem.service.TaskService;


@Controller
public class IndexController extends BaseController{

	@Resource
	private TaskService taskService;
	
	@RequestMapping("/")
	public String index(Model model){
		List mlist = taskService.findAll();
		model.addAttribute("list", mlist);
		return "index";
	}
	
	@PostMapping("/taskCreate")
	public String addTask(TaskCreateForm taskCreateForm) {
		taskService.save(getCurrentUser().getId(),taskCreateForm);
		return "index";
	}
	
	@GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable String id){
		taskService.delete(id);
		return "index";
	}
	@PostMapping("/update/{id}")
	public String updateTask(TaskCreateForm taskCreateForm,@PathVariable String id){
		taskService.update(taskCreateForm,id);
		return "index";
	}
	
}
