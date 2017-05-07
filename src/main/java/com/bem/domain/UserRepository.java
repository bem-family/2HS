package com.bem.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Component;


@Component
@Transactional
public class UserRepository {
	@PersistenceContext
	private EntityManager entityManager;	//实体管理器
	
	public Session getSession(){
		return entityManager.unwrap(Session.class);
	}
	
	//保存用户信息
	public void SaveUser(User user){
		getSession().save(user);
	}
	
	//保存账号信息
	public void SaveLocalAuth(LocalAuth localAuth){
		getSession().save(localAuth);
	}
	
}
