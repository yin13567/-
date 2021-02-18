package com.fuhao55170725.examsys.ejb.interfaces.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fuhao55170725.examsys.jpa.dao.QuestionsPaperDao;
import com.fuhao55170725.examsys.jpa.entity.QuestionsPaper;
import com.fuhao55170725.examsys.jpa.entity.Userinfo;
@Stateless
public class QuestionsPaperCtrl implements QuestionsPaperDao {

	@PersistenceContext(unitName="OnlineExamSystem") 
	private EntityManager em ;
	
	@Override
	public List<QuestionsPaper> findAllQuestionsPaper() {
		// TODO 自动生成的方法存根
		Query q=em.createQuery("from QuestionsPaper u");
		List <QuestionsPaper>results=q.getResultList();	
		return results;
	}

	@Override
	public void addQuestionsPaper(QuestionsPaper u) {
		// TODO 自动生成的方法存根
		em.persist(u);
	}

	@Override
	public void modifyQuestionsPaper(QuestionsPaper u) {
		// TODO 自动生成的方法存根
		em.merge(u);
	}

	@Override
	public void deleteQuestionsPaper(int id) {
		// TODO 自动生成的方法存根
		em.remove(em.find(QuestionsPaper.class, id));
	}

}
