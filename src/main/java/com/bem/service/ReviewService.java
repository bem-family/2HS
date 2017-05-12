package com.bem.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bem.domain.Review;
import com.bem.domain.ReviewRepository;
import com.bem.web.BaseController;

@Component
public class ReviewService {
	@Resource
	private ReviewRepository  reviewRepository;
	
	public void findAll(String id){
		reviewRepository.findAll(id);
	}
	public void add(Review review){
		reviewRepository.addReview(review);
	}
	
}
