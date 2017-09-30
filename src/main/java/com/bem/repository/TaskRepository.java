package com.bem.repository;


import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.bem.domain.Task;
import com.bem.utils.MyPage;

@Component
@Transactional
public class TaskRepository extends BaseRepository<Task> {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	/**
	 * 查找所有Task
	 * @return  MyPage<Task>
	 */
	public List<Task> findAll(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Task> query = builder.createQuery(Task.class);
		Root<Task> root  = query.from(Task.class);
		query.select(root);
		List<Task> mlist = entityManager.createQuery(query).getResultList();
		return mlist;
	}
	
	/**
	 * 查找所有Task，排序（）release_time降序）
	 * @return  MyPage<Task>
	 */
	public MyPage<Task> findByPageTask(){
		DetachedCriteria dc = DetachedCriteria.forClass(Task.class);
		dc.addOrder(Order.desc("release_time"));
		return findPageByCriteria(dc);
	}
	
	/**
	 * 通过userID查找Task
	 * @param userId
	 * @return MyPage<Task>
	 */
	public MyPage<Task> findByPageId(String userId){
		DetachedCriteria dc = DetachedCriteria.forClass(Task.class);
		dc.add(Property.forName("user_id").eq(userId));
		return findPageByCriteria(dc);
	}
	
	
	/**
	 * 通过classifyID查找Task
	 * @param classify
	 * @return	MyPage<Task>
	 */
	public MyPage<Task> findByPageClassify(String classify){
		DetachedCriteria dc = DetachedCriteria.forClass(Task.class);
		dc.add(Restrictions.eq("classify.id", classify));
		dc.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return findPageByCriteria(dc);
	}
	
	
	/**
	 * 查一个分类下的内容
	 * @param classifyId
	 * @return
	 */
	public MyPage<Task> findOneClassify(String classifyId) {
		DetachedCriteria dc = DetachedCriteria.forClass(Task.class);
		dc.add(Restrictions.eq("classify.id", classifyId));
		return findPageByCriteria(dc);
	}
	
	/**
	 * 通过TaskID查找Task
	 * @return  Task
	 */
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
	/**
	 * 删除一个Task，通过TaskID。（结果返回一个boolean值）
	 * @param id
	 * @return
	 */
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
	
}
