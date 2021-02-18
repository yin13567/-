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
import com.fuhao55170725.examsys.jsf.model.ForUserInfoBean;
import com.fuhao55170725.examsys.jsf.model.RegUserinfoBean;

@Named("forUserInfoCtrl")
@RequestScoped
public class ForUserInfoCtrl {

	@Inject @Named("forUserInfoBean")
	ForUserInfoBean fuib;
	@EJB
	private UserInfoDao uid;
	
	//判断是否属于用户
	public String forPass() {
		String userid=fuib.getUserid();
		String phone=fuib.getPhone();
		
		List<Userinfo>uiDatas=uid.findAllUserInfo();
		for(int i=0;i<uiDatas.size();i++) {
			Userinfo tmpuif=uiDatas.get(i);
			if(tmpuif.getUserid().equals( userid) && tmpuif.getPhone().equals(phone)) {
				int id=tmpuif.getId();
				fuib.setId(id);
				fuib.setAge(tmpuif.getAge());
				fuib.setGender(tmpuif.getGender());
				fuib.setUserid(tmpuif.getUserid());
				fuib.setPhone(tmpuif.getPhone());
				fuib.setRole(tmpuif.getRole());
				return "success";
			}
		}
		FacesMessage msg = new FacesMessage("登陆失败","无法认证您的身份");
		FacesContext.getCurrentInstance().addMessage("forform:saveinfo", msg);
		return null;
	}
	private String changePasswd(String passwd) {
		String res="";
		for(int i=0;i<passwd.length();i++) {
			char c=passwd.charAt(i);
			char cd=(char) (c+2);
			res+=cd;
		}
		return res;
	}
	
	//重置密码
	public String resetpasswd() {
		String pass=fuib.getUserpasswd();
		String pass1=fuib.getUserpasswd2();
		if(!pass.equals(pass1)) {
			FacesMessage msg = new FacesMessage("登陆失败","输入的密码不一致");
			FacesContext.getCurrentInstance().addMessage("resetForm:resetP", msg);
			return null;
		}
		Userinfo uitmp=new Userinfo();
		uitmp.setId(fuib.getId());
		uitmp.setAge(fuib.getAge());
		uitmp.setGender(fuib.getGender());
		uitmp.setPhone(fuib.getPhone());
		uitmp.setRole(fuib.getRole());
		uitmp.setUserid(fuib.getUserid());
		uitmp.setUserpasswd(changePasswd(fuib.getUserpasswd()));
		uid.modifyUserInfo(uitmp);
		return "index";
	}
}
