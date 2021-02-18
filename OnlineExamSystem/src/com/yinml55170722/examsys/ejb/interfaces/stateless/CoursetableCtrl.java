/**
 * 
 */
package com.fuhao55170725.examsys.ejb.interfaces.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fuhao55170725.examsys.jpa.dao.CoursetableDao;
import com.fuhao55170725.examsys.jpa.entity.Coursetable;

/**
 * @author fuhao
 *
 */
@Stateless
public class CoursetableCtrl implements CoursetableDao {

	@PersistenceContext(unitName="OnlineExamSystem") 
	private EntityManager em ;
	
	
	/* （非 Javadoc）
	 * @see com.fuhao55170725.examsys.jpa.dao.CoursetableDao#findAllCoursetable()
	 */
	@Override
	public List<Coursetable> findAllCoursetable() {
		// TODO 自动生成的方法存根
		Query q=em.createQuery("from Coursetable c");
		List <Coursetable>results=q.getResultList();	
		return results;
	}

	/* （非 Javadoc）
	 * @see com.fuhao55170725.examsys.jpa.dao.CoursetableDao#addUserInfo(com.fuhao55170725.examsys.jpa.entity.Coursetable)
	 */
	@Override
	public void addCoursetable(Coursetable c) {
		// TODO 自动生成的方法存根
		em.persist(c);
	}

	/* （非 Javadoc）
	 * @see com.fuhao55170725.examsys.jpa.dao.CoursetableDao#modifyUserInfo(com.fuhao55170725.examsys.jpa.entity.Coursetable)
	 */
	@Override
	public void modifyCoursetable(Coursetable c) {
		// TODO 自动生成的方法存根
		em.merge(c);
	}

	/* （非 Javadoc）
	 * @see com.fuhao55170725.examsys.jpa.dao.CoursetableDao#deleteUserInfo(int)
	 */
	@Override
	public void deleteCoursetable(int id) {
		// TODO 自动生成的方法存根
		em.remove(em.find(Coursetable.class, id));
	}

}
