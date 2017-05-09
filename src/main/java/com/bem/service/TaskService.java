package com.bem.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;
import com.bem.domain.Task;
import com.bem.domain.TaskCreateForm;
import com.bem.domain.TaskRepository;

@Component
public class TaskService {
	@Resource
	private TaskRepository taskRepository;

	public void save(String sessuserid, TaskCreateForm taskCreateForm){
		Task task = new Task();
		BeanUtils.copyProperties(taskCreateForm, task, Task.class);
		taskRepository.save(task);
	}
	public List<Task> findAll(){
		return taskRepository.findAll();
	}
}
