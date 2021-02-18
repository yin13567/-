package com.fuhao55170725.examsys.jpa.dao;

import java.util.List;

import javax.ejb.Remote;

import com.fuhao55170725.examsys.jpa.entity.Noticetable;
@Remote
public interface NoticetableDao {
	//查找
		public List<Noticetable> findAllNoticetable();
		//增加
		public void addNoticetable(Noticetable u);
		//修改
		public void modifyNoticetable(Noticetable u);
		//删除
		public void deleteNoticetable(int id);

}
