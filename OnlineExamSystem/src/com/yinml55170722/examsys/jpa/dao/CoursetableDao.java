package com.fuhao55170725.examsys.jpa.dao;

import java.util.List;

import javax.ejb.Remote;

import com.fuhao55170725.examsys.jpa.entity.Coursetable;
@Remote
public interface CoursetableDao {
	//查找
		public List<Coursetable> findAllCoursetable();
		//增加
		public void addCoursetable(Coursetable c);
		//修改
		public void modifyCoursetable(Coursetable c);
		//删除
		public void deleteCoursetable(int id);
}
