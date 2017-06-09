package com.bem.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
	
	public List<Quiz> findByRodaom(){
		List<Quiz> list = new ArrayList();
		Criteria criteria = getSession().createCriteria(Quiz.class);
		criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
		criteria.setMaxResults(3);
		list = criteria.list();
		return list;
	}
	
	public Quiz findByQuestion(String qu){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Quiz> query = builder.createQuery(Quiz.class);
		Root<Quiz> root  = query.from(Quiz.class);
		query.select(root);
		query.where(builder.equal(root.get("question"), qu));
		Quiz Quiz = entityManager.createQuery(query).getSingleResult();
		return Quiz;
	}
	
}
