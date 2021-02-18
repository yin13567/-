package com.fuhao55170725.examsys.ejb.interfaces.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fuhao55170725.examsys.jpa.dao.CourseTeaDao;
import com.fuhao55170725.examsys.jpa.entity.CourseTea;
import com.fuhao55170725.examsys.jpa.entity.Coursetable;


@Stateless
public class CourseTeaCtrl implements CourseTeaDao {

	@PersistenceContext(unitName="OnlineExamSystem") 
	private EntityManager em ;
	
	@Override
	public List<CourseTea> findAllCourseTea() {
		// TODO 自动生成的方法存根
		Query q=em.createQuery("from CourseTea c");
		List <CourseTea>results=q.getResultList();	
		return results;
	}

	@Override
	public void addCourseTea(CourseTea c) {
		// TODO 自动生成的方法存根
		em.persist(c);
	}

	@Override
	public void modifyCourseTea(CourseTea c) {
		// TODO 自动生成的方法存根
		em.merge(c);
	}

	@Override
	public void deleteCourseTea(int id) {
		// TODO 自动生成的方法存根
		em.remove(em.find(CourseTea.class, id));
	}

}
