package com.bem.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bem.utils.ID;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "LocalAuth")
public class LocalAuth {
	@Id
	private String id;		//UUID
	private String username;
	private String email;	//?
	private String phone;	//?
	private String password;
	
	@OneToOne()
	@JoinColumn(name ="user_id")
	private User user;
	
	public LocalAuth(){
		
	}
	
	public LocalAuth(String username, String email, String phone, String password, User user){
		this.id = ID.uuid();
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
