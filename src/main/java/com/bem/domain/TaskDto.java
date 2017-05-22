package com.bem.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class TaskDto {
	
	@NotEmpty(message = "The title must not be null")
	private String title;	// 标题
	@NotEmpty(message = "The content must not be null")
	private String content;	// 描述
	@NotEmpty(message = "The money must not be null")
	private String money;	// 价格
	@NotEmpty(message = "The address must not be null")
	private String address;	// 地址
	private String qq;	// 企鹅号
	@Size(min = 13, max = 13,message="input proper number")
	@NotEmpty(message = "The phone must not be null")
	private String phone;	// 联系电话
	private MultipartFile imagefile;	// 图片
	
	
	
	public TaskDto() {
		super();
	}
	
	
	public TaskDto(String title, String content, String money, String address, String qq, String phone,
			MultipartFile imagefile) {
		super();
		this.title = title;
		this.content = content;
		this.money = money;
		this.address = address;
		this.qq = qq;
		this.phone = phone;
		this.imagefile = imagefile;
	}


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
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public MultipartFile getImagefile() {
		return imagefile;
	}
	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}

	
}
