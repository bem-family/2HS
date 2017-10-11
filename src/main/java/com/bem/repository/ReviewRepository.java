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

import com.bem.domain.Quiz;
import com.bem.domain.Review;

@Component
@Transactional
public class ReviewRepository extends BaseRepository<Review>{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Review findById(String id){
		log.debug("find Review By Id");
		try {
			return findById(id, Review.class);
		} catch (RuntimeException e) {
			log.error("find Review By Id error",e);
			throw e;
		}
	}
	
	public void save(Review review){
		log.debug("save Review");
		try {
			getSession().save(review);
		} catch (RuntimeException e) {
			log.error("save Review error",e);
			throw e;
		}
	}
	
	public void deleteReview(String id){
		log.debug("detele Review");
		try {
			delete(id, Review.class);
		} catch (RuntimeException e) {
			log.error("detele Review error",e);
			throw e;
		}
	}
	
	/**
	 * 查找所有Review，通过主题ID（top_id） 通过创建时间（c_time）降序排列
	 * @param id
	 * @return
	 */
	public List<Review> findAll(String id){
		log.debug("find All Review by top_id desc c_time");
		try {
			CriteriaBuilder builder =	entityManager.getCriteriaBuilder();
			CriteriaQuery<Review> query = builder.createQuery(Review.class);
			Root<Review> root = query.from(Review.class);
			query.select(root);
			query.where(builder.equal(root.get("top_id"), id));
			query.orderBy(builder.desc(root.get("c_time")));
			List<Review> list = entityManager.createQuery(query).getResultList();
			log.debug("find All Review by top_id desc c_time successfull");
			return list;
		} catch (Exception e) {
			log.error("find All Review by top_id desc c_time",e);
			throw e;
		}
		
	}
	

}
