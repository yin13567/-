package com.fuhao55170725.examsys.jpa.dao;

import java.util.List;

import javax.ejb.Remote;

import com.fuhao55170725.examsys.jpa.entity.QuestionPersonal;
@Remote
public interface QuestionPersonalDao {
	//查找
		public List<QuestionPersonal> findAllQuestionPersonal();
		//增加
		public void addQuestionPersonal(QuestionPersonal u);
		//修改
		public void modifyQuestionPersonal(QuestionPersonal u);
		//删除
		public void deleteQuestionPersonal(int id);
}
