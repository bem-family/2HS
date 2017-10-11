package com.bem.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.bem.domain.Classify;
import com.bem.domain.Quiz;


@Component
@Transactional
public class QuizRepository extends BaseRepository<Quiz>{
	@PersistenceContext
	private EntityManager entityManager;	//实体管理器
	
	public List<Quiz> findAll(){
		log.debug("select List<Quiz>");
		try {
		DetachedCriteria dc = DetachedCriteria.forClass(Quiz.class);
		return findAllByCriteria(dc);
		} catch (RuntimeException e) {
			log.error("select List<Quiz> error",e);
			throw e;
		}
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
		log.debug("find Quiz By Question");
		try {
			return findById(qu, Quiz.class);
		} catch (RuntimeException e) {
			log.error("find Quiz By Question error",e);
			throw e;
		}
	}
	
}
