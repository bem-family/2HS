package com.bem.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.bem.domain.Review;

@Component
@Transactional
public class ReviewRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	public Review findById(String id){
		CriteriaBuilder builder =	entityManager.getCriteriaBuilder();
		CriteriaQuery<Review> query = builder.createQuery(Review.class);
		Root<Review> root = query.from(Review.class);
		query.where(builder.equal(root.get("id"), id));
		Review review = entityManager.createQuery(query).getSingleResult();
		return review;
	}
	
	public void addReview(Review review){
		getSession().save(review);
	}
	
	public void deleteReview(String id){
		Review review  = findById(id);
		getSession().delete(review);
	}
	
	public List<Review> findAll(String id){
		CriteriaBuilder builder =	entityManager.getCriteriaBuilder();
		CriteriaQuery<Review> query = builder.createQuery(Review.class);
		Root<Review> root = query.from(Review.class);
		query.select(root);
		query.where(builder.equal(root.get("top_id"), id));
		query.orderBy(builder.desc(root.get("c_time")));
		List<Review> list = entityManager.createQuery(query).getResultList();
		return list;
	}
	

}
