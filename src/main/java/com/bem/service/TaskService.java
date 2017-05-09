package com.bem.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bem.domain.Task;
import com.bem.domain.TaskDto;
import com.bem.domain.TaskRepository;

@Component
public class TaskService {
	@Resource
	private TaskRepository taskRepository;

	public void save(String sessuserid, TaskDto taskCreateForm) {
		
		MultipartFile mfile = taskCreateForm.getImagefile();	//得到图片文件
		String mFileName = new Date().getTime() + mfile.getOriginalFilename();	// 文件名
		System.out.println(mFileName);
		// 储存缓存文件地址
		String Path = Class.class.getClass().getResource("/").getPath() + "static/images/";
		File file = new File(Path);
		// 创建文件夹
		if (!file.isDirectory()) {
			file.mkdir();
		}
		String imageFilePath = Path + mFileName;
		// 移动文件夹到指定目录
		if (mfile.isEmpty()) {

		} else {
			File mImageFile = new File(imageFilePath);
			try {
				mfile.transferTo(mImageFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Task task = new Task();
			BeanUtils.copyProperties(taskCreateForm, task, Task.class);
			taskRepository.save(task);
		}
	}
}
