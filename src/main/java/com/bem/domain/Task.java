package com.bem.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.alibaba.fastjson.JSON;
import com.bem.utils.Time;

@Entity
public class Task implements Serializable {
	@Id
	private String id;
	private String title;//标题
	private String content;//描述
	private String money;//价格
	private String address;//地址
	private String user_id;//用户id
	private String authenticate;//认证状态
	private String qq;//企鹅号
	private String phone;//联系电话
	private Timestamp release_time;//发布时间
	private String list_img;//图片集
	private String scope;//所属范围
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Classify classify;
	
	public Task(){
		this.id = UUID.randomUUID().toString();
		this.release_time = (new Time()).timestamp();
	}
	
	public Task(String userid){
		this.user_id = userid;
	}
	
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
	public Timestamp getRelease_time() {
		return release_time;
	}

	public void setRelease_time(Timestamp release_time) {
		this.release_time = release_time;
	}

	public List<String> getList_img() {
		return JSON.parseArray(list_img,String.class);
	}
	public void setList_img(List<String> list_img) {
		this.list_img = JSON.toJSONString(list_img);
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}


	public Classify getClassify() {
		return classify;
	}

	public void setClassify(Classify classify) {
		this.classify = classify;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
