package com.fuhao55170725.examsys.jpa.dao;

import java.util.List;

import javax.ejb.Remote;

import com.fuhao55170725.examsys.jpa.entity.QuestionsPaper;
@Remote
public interface QuestionsPaperDao {
	//查找
		public List<QuestionsPaper> findAllQuestionsPaper();
		//增加
		public void addQuestionsPaper(QuestionsPaper u);
		//修改
		public void modifyQuestionsPaper(QuestionsPaper u);
		//删除
		public void deleteQuestionsPaper(int id);
}
