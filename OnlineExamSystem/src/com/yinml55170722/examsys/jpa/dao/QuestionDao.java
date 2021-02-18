package com.fuhao55170725.examsys.jpa.dao;

import java.util.List;

import javax.ejb.Remote;

import com.fuhao55170725.examsys.jpa.entity.Question;
@Remote
public interface QuestionDao {
	//查找
		public List<Question> findQuestion();
		//增加
		public void addQuestion(Question u);
		//修改
		public void modifyQuestion(Question u);
		//删除
		public void deleteQuestion(int id);
}
