package com.fuhao55170725.examsys.ejb.interfaces.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fuhao55170725.examsys.jpa.dao.TestPaperDao;
import com.fuhao55170725.examsys.jpa.entity.Testpaper;
@Stateless
public class TestpaperCtrl implements TestPaperDao {

	@PersistenceContext(unitName="OnlineExamSystem") 
	private EntityManager em ;
	
	@Override
	public List<Testpaper> findAllTestPaper() {
		// TODO 自动生成的方法存根
		Query q=em.createQuery("from Testpaper u");
		List <Testpaper>results=q.getResultList();	
		return results;
	}

	@Override
	public void addTestPaper(Testpaper u) {
		// TODO 自动生成的方法存根
		em.persist(u);
	}

	@Override
	public void modifyTestPaper(Testpaper u) {
		// TODO 自动生成的方法存根
		em.merge(u);
	}

	@Override
	public void deleteTestPaper(int id) {
		// TODO 自动生成的方法存根
		em.remove(em.find(Testpaper.class, id));
	}

}
