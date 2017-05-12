package com.bem.domain;



import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.aspectj.weaver.ast.And;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class ReviewRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	
	public void addReview(Review review){
		getSession().save(review);
	}
	
	
	public List<Review> findAll(String id){
		CriteriaBuilder builder =	entityManager.getCriteriaBuilder();
		CriteriaQuery<Review> query = builder.createQuery(Review.class);
		Root<Review> root = query.from(Review.class);
		query.select(root);
		query.where(builder.and(builder.equal(root.get("top_id"), id)));
		
		List<Review> list = entityManager.createQuery(query).getResultList();
		return list;
	}
	

}
