package com.fuhao55170725.examsys.jpa.dao;

import java.util.List;

import javax.ejb.Remote;

import com.fuhao55170725.examsys.jpa.entity.Userinfo;

@Remote
public interface UserInfoDao {
	//查找
	public List<Userinfo> findAllUserInfo();
	//增加
	public void addUserInfo(Userinfo u);
	//修改
	public void modifyUserInfo(Userinfo u);
	//删除
	public void deleteUserInfo(int id);


}
