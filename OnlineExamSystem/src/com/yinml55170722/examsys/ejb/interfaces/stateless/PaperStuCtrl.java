package com.fuhao55170725.examsys.ejb.interfaces.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fuhao55170725.examsys.jpa.dao.PaperStuDao;
import com.fuhao55170725.examsys.jpa.entity.PaperStu;
@Stateless
public class PaperStuCtrl implements PaperStuDao {

	@PersistenceContext(unitName="OnlineExamSystem") 
	private EntityManager em ;
	
	@Override
	public List<PaperStu> findAllPaperStu() {
		// TODO 自动生成的方法存根
		Query q=em.createQuery("from PaperStu u");
		List <PaperStu>results=q.getResultList();	
		return results;
	}

	@Override
	public void addPaperStu(PaperStu u) {
		// TODO 自动生成的方法存根
		em.persist(u);
	}

	@Override
	public void modifyPaperStu(PaperStu u) {
		// TODO 自动生成的方法存根
		em.merge(u);
	}

	@Override
	public void deletePaperStu(int id) {
		// TODO 自动生成的方法存根
		em.remove(em.find(PaperStu.class, id));
	}

}
