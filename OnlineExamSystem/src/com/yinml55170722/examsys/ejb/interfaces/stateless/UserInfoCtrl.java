package com.fuhao55170725.examsys.ejb.interfaces.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fuhao55170725.examsys.jpa.dao.UserInfoDao;
import com.fuhao55170725.examsys.jpa.entity.Userinfo;

@Stateless
public class UserInfoCtrl implements UserInfoDao {

	@PersistenceContext(unitName="OnlineExamSystem") 
	private EntityManager em ;
	
	@Override
	public List<Userinfo> findAllUserInfo() {
		// TODO 自动生成的方法存根
		Query q=em.createQuery("from Userinfo u");
		List <Userinfo>results=q.getResultList();	
		return results;
	}

	@Override
	public void addUserInfo(Userinfo u) {
		// TODO 自动生成的方法存根
		em.persist(u);
	}

	@Override
	public void modifyUserInfo(Userinfo u) {
		// TODO 自动生成的方法存根
		em.merge(u);
	}

	@Override
	public void deleteUserInfo(int id) {
		// TODO 自动生成的方法存根
		em.remove(em.find(Userinfo.class, id));
	}

}
