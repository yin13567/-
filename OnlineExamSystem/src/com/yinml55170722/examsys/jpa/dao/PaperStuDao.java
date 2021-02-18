package com.fuhao55170725.examsys.jpa.dao;

import java.util.List;

import javax.ejb.Remote;

import com.fuhao55170725.examsys.jpa.entity.PaperStu;
@Remote
public interface PaperStuDao {
	//查找
		public List<PaperStu> findAllPaperStu();
		//增加
		public void addPaperStu(PaperStu u);
		//修改
		public void modifyPaperStu(PaperStu u);
		//删除
		public void deletePaperStu(int id);
}
