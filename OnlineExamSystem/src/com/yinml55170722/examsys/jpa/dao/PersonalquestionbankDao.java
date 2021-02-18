package com.fuhao55170725.examsys.jpa.dao;

import java.util.List;

import javax.ejb.Remote;

import com.fuhao55170725.examsys.jpa.entity.Personalquestionbank;
@Remote
public interface PersonalquestionbankDao {
	//查找
		public List<Personalquestionbank> findAllPersonalquestionbank();
		//增加
		public void addPersonalquestionbank(Personalquestionbank u);
		//修改
		public void modifyPersonalquestionbank(Personalquestionbank u);
		//删除
		public void deletePersonalquestionbank(int id);
}
