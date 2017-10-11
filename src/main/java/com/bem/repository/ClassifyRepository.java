package com.bem.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.bem.domain.Classify;
import com.bem.domain.Task;

@Component
@Transactional
public class ClassifyRepository extends BaseRepository<Classify>{

	public void save(Classify classify) {
		try {
			getSession().save(classify);
		} catch (RuntimeException e) {
			log.error("save classify error");
			throw e;
		}
	}
	
	/** 
	 * 全部分类
	 * @return
	 */
	public List<Classify> findAllClassify() {
		log.debug("select List<Classify>");
		try {
		DetachedCriteria dc = DetachedCriteria.forClass(Classify.class);
		return findAllByCriteria(dc);
		} catch (RuntimeException e) {
			log.error("select List<Classify> error",e);
			throw e;
		}
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
