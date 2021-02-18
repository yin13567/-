package com.fuhao55170725.examsys.jpa.dao;

import java.util.List;

import javax.ejb.Remote;

import com.fuhao55170725.examsys.jpa.entity.Stuan;
@Remote
public interface StuanDao {
	//查找
		public List<Stuan> findAllStuan();
		//增加
		public void addStuan(Stuan u);
		//修改
		public void modifyStuan(Stuan u);
		//删除
		public void deleteStuan(int id);
}
