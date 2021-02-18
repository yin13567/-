package com.fuhao55170725.examsys.ejb.interfaces.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fuhao55170725.examsys.jpa.dao.NoticetableDao;
import com.fuhao55170725.examsys.jpa.entity.Noticetable;
@Stateless
public class NoticetableCtrl implements NoticetableDao {
	@PersistenceContext(unitName="OnlineExamSystem") 
	private EntityManager em ;
	
	
	@Override
	public List<Noticetable> findAllNoticetable() {
		// TODO 自动生成的方法存根
		Query q=em.createQuery("from Noticetable c");
		List <Noticetable>results=q.getResultList();	
		return results;
	}

	@Override
	public void addNoticetable(Noticetable u) {
		// TODO 自动生成的方法存根
		em.persist(u);
	}

	@Override
	public void modifyNoticetable(Noticetable u) {
		// TODO 自动生成的方法存根
		em.merge(u);
	}

	@Override
	public void deleteNoticetable(int id) {
		// TODO 自动生成的方法存根
		em.remove(em.find(Noticetable.class, id));
	}

	

}
