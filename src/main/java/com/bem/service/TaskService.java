package com.bem.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bem.domain.Task;
import com.bem.domain.TaskCreateForm;
import com.bem.domain.TaskRepository;

public class TaskService {
	@Autowired
	private TaskRepository taskRepository;

	public void save(String sessuserid, TaskCreateForm taskCreateForm){
		Task task = new Task(sessuserid);
		BeanUtils.copyProperties(taskCreateForm, task, Task.class);
		taskRepository.save();
	}
}
