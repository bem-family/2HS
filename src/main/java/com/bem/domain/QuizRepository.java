package com.bem.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Component;


@Component
@Transactional
public class QuizRepository {
	@PersistenceContext
	private EntityManager entityManager;	//实体管理器
	
	public Session getSession(){
		return entityManager.unwrap(Session.class);
	}
	
	public List<Quiz> findAll(){
		List<Quiz> list = getSession().createCriteria(Quiz.class).list();
		return list;
	}
}
