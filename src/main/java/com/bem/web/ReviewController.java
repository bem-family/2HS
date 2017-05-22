package com.bem.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bem.domain.Review;
import com.bem.service.ReviewService;

@Controller
public class ReviewController extends BaseController{
	@Resource
	private ReviewService reviewService;
	
	
	@RequestMapping("/review/@{id}")
	public String index(Model model,@PathVariable String id){
		reviewService.findAll(id);
		//model.addAttribute(arg0)
		return "review";
	}
	@ResponseBody
	@PostMapping("/review/add")
	public String add(Review review){
	review.setComment_id(getCurrentUser().getId());
	reviewService.add(review);
	return "true";
	}
	
}
