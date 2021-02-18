package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.UserInfoDao;
import com.fuhao55170725.examsys.jpa.entity.Userinfo;
import com.fuhao55170725.examsys.jsf.model.RegUserinfoBean;
import com.fuhao55170725.examsys.jsf.model.UserExamInfoBean;

@Named("regUserinfoCtrl")
@RequestScoped
public class RegUserinfoCtrl {

	@Inject @Named("regUserinfoBean")
	RegUserinfoBean ruib;
	
	@EJB
	private UserInfoDao uid;
	
	private String changePasswd(String passwd) {
		String res="";
		for(int i=0;i<passwd.length();i++) {
			char c=passwd.charAt(i);
			char cd=(char) (c+2);
			res+=cd;
		}
		return res;
	}
	
	//保存信息
	public String saveInfo() {
		String res=null;
		Userinfo uitmp=new Userinfo();
		uitmp.setAge(ruib.getAge());
		uitmp.setGender(ruib.getGender());
		uitmp.setPhone(ruib.getPhone());
		uitmp.setRole(ruib.getRole());
		uitmp.setUserid(ruib.getUserid());
		uitmp.setUserpasswd(ruib.getUserpasswd());
		
		List<Userinfo>uiDatas=uid.findAllUserInfo();
		for(int i=0;i<uiDatas.size();i++) {
			Userinfo tmpuif=uiDatas.get(i);
			if(tmpuif.getUserid().equals( uitmp.getUserid()) ){
				FacesMessage msg = new FacesMessage("注册失败","用户名重复,请重新输入");
				FacesContext.getCurrentInstance().addMessage("regform:userid", msg);
				return res;
			}
		}
		/*
		//验证密码
		if(uitmp.getUserpasswd().length()<8) {
			FacesMessage msg = new FacesMessage("注册失败","密码至少8位");
			FacesContext.getCurrentInstance().addMessage("regform:pwd", msg);
			return res;
		}
		for(int i=0;i<uitmp.getUserpasswd().length();i++) {
			char c=uitmp.getUserpasswd().charAt(i);
			if(!((c>='0'&&c<='9')||(c>='a'&&c<='z')||(c>='A'&&c<='Z'))) {
				FacesMessage msg = new FacesMessage("注册失败","请输入数字或字母");
				FacesContext.getCurrentInstance().addMessage("regform:pwd", msg);
				return res;
			}
		}
		boolean hasN=false;
		boolean hasC=false;
		for(int i=0;i<uitmp.getUserpasswd().length();i++) {
			char c=uitmp.getUserpasswd().charAt(i);
			if((c>='0'&&c<='9')) {
				hasN=true;
			}
			if((c>='a'&&c<='z')||(c>='A'&&c<='Z')) {
				hasC=true;
			}	
			if(hasN && hasC)break;
		}
		if(!hasN || !hasC) {
			FacesMessage msg = new FacesMessage("注册失败","必须数字或字母的组合");
			FacesContext.getCurrentInstance().addMessage("regform:pwd", msg);
			return res;
		}*/
		uitmp.setUserpasswd(changePasswd( uitmp.getUserpasswd()));
		uid.addUserInfo(uitmp);
		res="index";
		return res;
	}
}
