package com.fuhao55170725.examsys.jpa.dao;

import java.util.List;

import javax.ejb.Remote;

import com.fuhao55170725.examsys.jpa.entity.CourseTea;

@Remote
public interface CourseTeaDao {
	//查找
			public List<CourseTea> findAllCourseTea();
			//增加
			public void addCourseTea(CourseTea c);
			//修改
			public void modifyCourseTea(CourseTea c);
			//删除
			public void deleteCourseTea(int id);
}
