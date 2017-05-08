package com.bem.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class UserRepository {
	@PersistenceContext
	private EntityManager entityManager;	//实体管理器
	
	public Session getSession(){
		return entityManager.unwrap(Session.class);
	}
	
	//保存用户信息
	public void SaveUser(User user){
		getSession().save(user);
	}
	
	//保存账号信息
	public void SaveLocalAuth(LocalAuth localAuth){
		getSession().save(localAuth);
	}
	
	public LocalAuth findUserByAccount(String account){
		LocalAuth localAuth = new LocalAuth();
		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<LocalAuth> query  = builder.createQuery(LocalAuth.class);
			Root<LocalAuth> root =query.from(LocalAuth.class);
			Predicate conditionForName = builder.equal(root.get("username"), account);
		    Predicate conditionForEmail = builder.equal(root.get("email"), account);
		    Predicate conditionForPhone = builder.equal(root.get("phone"), account);
		    Predicate condition3 = builder.or(conditionForName,conditionForEmail,conditionForPhone);
			query.where(condition3);
			localAuth = entityManager.createQuery(query).getSingleResult();
		}catch(Exception e){
			return null;
		}
		return localAuth;
	}	
}
