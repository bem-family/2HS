package com.bem.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bem.domain.ClassifyDto;
import com.bem.domain.Task;
import com.bem.service.ClassifyService;

@Controller
public class ClassifyController extends BaseController{
	
	@Resource
	private ClassifyService classifyService;

	/**
	 * 查询分类下的内容
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/classify/{id}/findDetails")
	public String findOneClassify(Model model ,@PathVariable String id){
		List<Task> list = classifyService.findOneClassify(id);
		model.addAttribute("list", list);
		return "details";
	}
	
	/**
	 * 创建一个分类
	 * @param classifyDto
	 * @return
	 */
	@PostMapping("/createClassify")
	public String createClassify(ClassifyDto classifyDto){
		classifyService.saveClassify(getCurrentUser().getId(),classifyDto);
		return "redirect:/";
	}
}
