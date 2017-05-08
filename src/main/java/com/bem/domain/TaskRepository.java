package com.bem.domain;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Component;



import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class TaskRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	public void save(Task task) {
		getSession().save(task);
	}
}
