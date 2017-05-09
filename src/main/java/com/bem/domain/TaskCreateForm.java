package com.bem.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.Message;

public class TaskCreateForm {
	
	@NotEmpty
	private String title;	// 标题
	@NotEmpty
	private String content;	// 描述
	@NotEmpty
	private String money;	// 价格
	@NotEmpty
	private String address;	// 地址
	private String qq;	// 企鹅号
	@Size(min = 13, max = 13)
	@NotEmpty
	private String phone;	// 联系电话

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
	
	
}
