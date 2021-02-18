package com.fuhao55170725.examsys.ejb.interfaces.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.fuhao55170725.examsys.jpa.dao.StuanDao;
import com.fuhao55170725.examsys.jpa.entity.Stuan;
@Stateless
public class StuanDaoCtrl implements StuanDao {

	@PersistenceContext(unitName="OnlineExamSystem") 
	private EntityManager em ;
	
	@Override
	public List<Stuan> findAllStuan() {
		// TODO 自动生成的方法存根
		Query q=em.createQuery("from Stuan u");
		List <Stuan>results=q.getResultList();
		return results;
	}

	@Override
	public void addStuan(Stuan u) {
		// TODO 自动生成的方法存根
		em.persist(u);
	}

	@Override
	public void modifyStuan(Stuan u) {
		// TODO 自动生成的方法存根
		em.merge(u);
	}

	@Override
	public void deleteStuan(int id) {
		// TODO 自动生成的方法存根
		em.remove(em.find(Stuan.class, id));
	}

}
