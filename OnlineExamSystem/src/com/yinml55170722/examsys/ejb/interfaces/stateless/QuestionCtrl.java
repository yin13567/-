package com.fuhao55170725.examsys.ejb.interfaces.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fuhao55170725.examsys.jpa.dao.QuestionDao;
import com.fuhao55170725.examsys.jpa.entity.Question;
@Stateless
public class QuestionCtrl implements QuestionDao {

	@PersistenceContext(unitName="OnlineExamSystem") 
	private EntityManager em ;
	
	@Override
	public List<Question> findQuestion() {
		// TODO 自动生成的方法存根
		Query q=em.createQuery("from Question u");
		List <Question>results=q.getResultList();	
		return results;
	}

	@Override
	public void addQuestion(Question u) {
		// TODO 自动生成的方法存根
		em.persist(u);
	}

	@Override
	public void modifyQuestion(Question u) {
		// TODO 自动生成的方法存根
		em.merge(u);
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO 自动生成的方法存根
		em.remove(em.find(Question.class, id));
	}

}
