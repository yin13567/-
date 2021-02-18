package com.fuhao55170725.examsys.ejb.interfaces.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fuhao55170725.examsys.jpa.dao.QuestionPersonalDao;
import com.fuhao55170725.examsys.jpa.entity.QuestionPersonal;
@Stateless
public class QuestionPersonalCtrl implements QuestionPersonalDao {

	@PersistenceContext(unitName="OnlineExamSystem") 
	private EntityManager em;
	
	
	@Override
	public List<QuestionPersonal> findAllQuestionPersonal() {
		// TODO 自动生成的方法存根
		Query q=em.createQuery("from QuestionPersonal u");
		List <QuestionPersonal>results=q.getResultList();	
		return results;
	}

	@Override
	public void addQuestionPersonal(QuestionPersonal u) {
		// TODO 自动生成的方法存根
		em.persist(u);
	}

	@Override
	public void modifyQuestionPersonal(QuestionPersonal u) {
		// TODO 自动生成的方法存根
		em.merge(u);
	}

	@Override
	public void deleteQuestionPersonal(int id) {
		// TODO 自动生成的方法存根
		em.remove(em.find(QuestionPersonal.class, id));
	}

}
