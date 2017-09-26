package com.bem.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bem.domain.Classify;
import com.bem.domain.ClassifyDto;
import com.bem.domain.Task;
import com.bem.repository.ClassifyRepository;

@Component
public class ClassifyService {

	@Resource
	private ClassifyRepository classifyRepository;
	
	public List<Classify> findAllClassify(){
		return classifyRepository.findAllClassify();
	}
	
	public void saveClassify(String userId ,ClassifyDto classifyDto){
		Classify classify = new Classify();
		BeanUtils.copyProperties(classifyDto, classify, Classify.class);
		classifyRepository.save(classify);
	}
	
	public List<Task> findOneClassify(String classifyId){
		return classifyRepository.findOneClassify(classifyId);
	}
}
