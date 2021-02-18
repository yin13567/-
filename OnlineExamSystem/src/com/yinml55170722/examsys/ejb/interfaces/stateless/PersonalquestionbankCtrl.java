package com.fuhao55170725.examsys.ejb.interfaces.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fuhao55170725.examsys.jpa.dao.PersonalquestionbankDao;
import com.fuhao55170725.examsys.jpa.entity.Personalquestionbank;
@Stateless
public class PersonalquestionbankCtrl implements PersonalquestionbankDao {

	@PersistenceContext(unitName="OnlineExamSystem") 
	private EntityManager em ;
	
	@Override
	public List<Personalquestionbank> findAllPersonalquestionbank() {
		// TODO 自动生成的方法存根
		Query q=em.createQuery("from Personalquestionbank u");
		List <Personalquestionbank>results=q.getResultList();	
		return results;
	}

	@Override
	public void addPersonalquestionbank(Personalquestionbank u) {
		// TODO 自动生成的方法存根
		em.persist(u);
	}

	@Override
	public void modifyPersonalquestionbank(Personalquestionbank u) {
		// TODO 自动生成的方法存根
		em.merge(u);
	}

	@Override
	public void deletePersonalquestionbank(int id) {
		// TODO 自动生成的方法存根
		em.remove(em.find(Personalquestionbank.class, id));
	}

}
