package com.bem.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bem.domain.Review;
import com.bem.domain.ReviewRepository;
import com.bem.web.BaseController;

@Component
public class ReviewService {
	@Resource
	private ReviewRepository  reviewRepository;
	
	public List<Review> findAll(String id){
		return reviewRepository.findAll(id);
	}
	public void add(Review review){
		reviewRepository.addReview(review);
	}
	public void delete(String id){
		reviewRepository.deleteReview(id);
	}
	
}
