package com.bem.domain;

import org.springframework.web.multipart.MultipartFile;

public class TaskDto {
	
	private String title;	// 标题
	private String content;	// 描述
	private String money;	// 价格
	private String address;	// 地址
	private String qq;	// 企鹅号
	private String phone;	// 联系电话
	private MultipartFile imagefile;	// 图片
	
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
