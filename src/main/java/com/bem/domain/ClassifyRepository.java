package com.bem.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class ClassifyRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	public void save(Classify classify) {
		getSession().save(classify);
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
	
	/**
	 * 查一个分类下的内容
	 * @param classifyId
	 * @return
	 */
	public List<Task> findOneClassify(String classifyId) {
		DetachedCriteria dc = DetachedCriteria.forClass(Task.class);
		dc.add(Restrictions.eq("classify.id", classifyId));
		Criteria criteria = dc.getExecutableCriteria(getSession());
		return criteria.list();
	}
	
	/**
	 * 查一个分类对象
	 * @param classifyId
	 * @return
	 */
	public Classify findOneById(String classifyId){
		DetachedCriteria dc = DetachedCriteria.forClass(Classify.class);
		dc.add(Restrictions.eq("id", classifyId));
		Criteria criteria = dc.getExecutableCriteria(getSession());
		List<Classify> list = criteria.list();
		Classify classify = new Classify();
		for(Classify item : list){
			classify = item;
		}
		return classify;
	}
}
