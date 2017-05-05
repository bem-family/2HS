package com.bem.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	private String id;
	private String title;//标题
	private String content;//简介
	private String money;//金钱
	private String address;//地址
	private String user_id;//用户id
	private String authenticate;//认证状态
	private String qq;//企鹅号
	private String phone;//联系电话
	private String release_time;//发布时间
	private String list_img;//图片集
	private String scope;//所属范围
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAuthenticate() {
		return authenticate;
	}
	public void setAuthenticate(String authenticate) {
		this.authenticate = authenticate;
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
	public String getRelease_time() {
		return release_time;
	}
	public void setRelease_time(String release_time) {
		this.release_time = release_time;
	}
	public String getList_img() {
		return list_img;
	}
	public void setList_img(String list_img) {
		this.list_img = list_img;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
