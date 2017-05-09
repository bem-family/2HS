package com.bem.web;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bem.domain.TaskCreateForm;
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
	
	@GetMapping("/403")
    public String forbidden(){
        return "403";
    }
	
	@PreAuthorize("hasAnyAuthority('USER')")
	@GetMapping("/newPage")
	public String newpage(){
		return "new";
	}
	
	//新增一条首页信息
	@PostMapping("/taskCreate")
	public String create(TaskCreateForm taskCreateForm) {
		taskService.save(sessuserid,taskCreateForm);
		return "index";
	}
}
