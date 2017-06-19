package com.bem.domain;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class TaskDto {
	
	@NotEmpty(message = "The title must not be null")
	private String title;	// 标题
	@NotEmpty(message = "The content must not be null")
	private String content;	// 描述
	@NotEmpty(message = "The address must not be null")
	private String address;	// 地址
	private String qq;	// 企鹅号
	private ArrayList<MultipartFile> imagefile;	// 图片
	private String classify;
	
	
	
	public TaskDto() {
		super();
	}
	
	
/*	public TaskDto(String title, String content, String money, String address, String qq, String phone,
			MultipartFile imagefile) {
		super();
		this.title = title;
		this.content = content;
		this.address = address;
		this.qq = qq;
	}*/


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	
}
