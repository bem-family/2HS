package com.bem.domain;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class TaskRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	public Task findId(String id){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Task> query = builder.createQuery(Task.class);
		Root<Task> root  = query.from(Task.class);
		query.select(root);
		query.where(builder.equal(root.get("id"), id));
		Task task = entityManager.createQuery(query).getSingleResult();
		return task;
	}
	
	public void save(Task task) {
		getSession().save(task);
	}
	
	public List<Task> findAll(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Task> query = builder.createQuery(Task.class);
		Root<Task> root  = query.from(Task.class);
		query.select(root);
		List<Task> mlist = entityManager.createQuery(query).getResultList();
		return mlist;
	}
	
	
	public boolean delete(String id){
		Task task = findId(id);
		if(task.getId()!=null){
			getSession().delete(task);
			return true;
		}
		return false;
	}
	
	public void update(Task task){
		getSession().update(task);
	}
	
	/**
	 * 全部分类
	 * @return
	 */
	public List<Classify> findAllClassify() {
		DetachedCriteria dc = DetachedCriteria.forClass(Classify.class);
		Criteria criteria = dc.getExecutableCriteria(getSession());
		return criteria.list();
	}
	
	public void saveOneClassify(Classify classify) {
		getSession().save(classify);
	}
	
	public List<Task> findOneClassification(String kidClassificationId) {
		DetachedCriteria dc = DetachedCriteria.forClass(Task.class);
		dc.add(Restrictions.eq("classify.id", kidClassificationId));
		Criteria criteria = dc.getExecutableCriteria(getSession());
		return criteria.list();
	}
	
	public Classify findOneById(String classifyById){
		DetachedCriteria dc = DetachedCriteria.forClass(Classify.class);
		dc.add(Restrictions.eq("id", classifyById));
		Criteria criteria = dc.getExecutableCriteria(getSession());
		List<Classify> list = criteria.list();
		Classify classify = new Classify();
		for(Classify item : list){
			classify = item;
		}
		return classify;
	}
}
