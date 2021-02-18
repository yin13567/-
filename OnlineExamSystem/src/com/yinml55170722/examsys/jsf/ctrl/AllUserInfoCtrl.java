package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.CoursetableDao;
import com.fuhao55170725.examsys.jpa.dao.UserInfoDao;
import com.fuhao55170725.examsys.jpa.entity.Userinfo;
import com.fuhao55170725.examsys.jsf.model.AllUserInfoBean;
import com.fuhao55170725.examsys.jsf.model.CourseBean;
import com.fuhao55170725.examsys.jsf.model.TmpUserInfoBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("allUserInfoCtrl")
@RequestScoped
public class AllUserInfoCtrl {
	
	@Inject @Named("allUserInfoBean")
	private AllUserInfoBean aib;

	@Inject @Named("tmpUserInfoBean")
	private TmpUserInfoBean tib;
	
	@EJB
	private UserInfoDao uid;
	private String changePasswd(String passwd) {
		String res="";
		for(int i=0;i<passwd.length();i++) {
			char c=passwd.charAt(i);
			char cd=(char) (c-2);
			res+=cd;
		}
		return res;
	}
	
	private String changePasswd1(String passwd) {
		String res="";
		for(int i=0;i<passwd.length();i++) {
			char c=passwd.charAt(i);
			char cd=(char) (c+2);
			res+=cd;
		}
		return res;
	}
	//设置所有的用户信息
	public void setAllInfo() {
		List<Userinfo>uiDatas=uid.findAllUserInfo();
		
		List<Integer>id=new ArrayList<Integer>();
		List<String>userid=new ArrayList<String>();
		List<String>passwd=new ArrayList<String>();
		List<Integer>age=new ArrayList<Integer>();
		List<Integer>gender=new ArrayList<Integer>();
		List<String>phone=new ArrayList<String>();
		List<Integer>role=new ArrayList<Integer>();
		
		for(int i=0;i<uiDatas.size();i++) {
			Userinfo tmpuif=uiDatas.get(i);
			id.add(tmpuif.getId());
			userid.add(tmpuif.getUserid());
			passwd.add(changePasswd( tmpuif.getUserpasswd()));
			age.add(tmpuif.getAge());
			gender.add(tmpuif.getGender());
			phone.add(tmpuif.getPhone());
			role.add(tmpuif.getRole());
		}
		
		aib.setAge(age);
		aib.setGender(gender);
		aib.setPasswd(passwd);
		aib.setPhone(phone);
		aib.setRole(role);
		aib.setUserid(userid);
		aib.setId(id);
		System.out.println("已经执行了 ");
		System.out.println("大小是: "+id.size());
	}
	
	//修改用户信息
	public void changeUserInfo(ActionEvent event) {
		int id=(int)event.getComponent().getAttributes().get("idindex");
		List<Userinfo>uiDatas=uid.findAllUserInfo();
		for(int i=0;i<uiDatas.size();i++) {
			Userinfo tmpuif=uiDatas.get(i);
			if(tmpuif.getId()==id) {
				tib.setId(id);
				tib.setAge(tmpuif.getAge());
				tib.setGender(tmpuif.getGender());
				tib.setPhone(tmpuif.getPhone());
				tib.setRole(tmpuif.getRole());
				tib.setUserid(tmpuif.getUserid());
				tib.setUserpasswd(changePasswd( tmpuif.getUserpasswd()));
			}
		}
		System.out.println("函数执行成功");
		System.out.println("用户的id是:"+tib.getId());
	}
	
}
