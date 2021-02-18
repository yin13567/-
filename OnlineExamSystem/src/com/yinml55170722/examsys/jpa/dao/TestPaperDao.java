package com.fuhao55170725.examsys.jpa.dao;

import java.util.List;

import javax.ejb.Remote;

import com.fuhao55170725.examsys.jpa.entity.Testpaper;
@Remote
public interface TestPaperDao {
	//查找
		public List<Testpaper> findAllTestPaper();
		//增加
		public void addTestPaper(Testpaper u);
		//修改
		public void modifyTestPaper(Testpaper u);
		//删除
		public void deleteTestPaper(int id);
}
