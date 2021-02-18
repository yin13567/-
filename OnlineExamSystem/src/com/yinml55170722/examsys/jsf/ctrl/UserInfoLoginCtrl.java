package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jms.AsyncMesConsumer;
import com.fuhao55170725.examsys.jpa.dao.UserInfoDao;
import com.fuhao55170725.examsys.jpa.entity.Userinfo;
import com.fuhao55170725.examsys.jsf.model.TmpUserInfoBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("userInfoLoginCtrl")
@RequestScoped
public class UserInfoLoginCtrl {
	@Inject @Named("userInfoBean")
	UserInfoBean user;
	
	@Inject @Named("tmpUserInfoBean")
	TmpUserInfoBean tmpUserInfoBean;
	
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
	
	//验证用户登录
	public String login() {
		List<Userinfo>databaseDatas=uid.findAllUserInfo();
		boolean hasusername=false;
		boolean hasuserpasswd=false;
		int role=0;
		
		for(int i=0;i<databaseDatas.size();i++) {
			Userinfo tmpui=databaseDatas.get(i);
			String tmpusername=tmpui.getUserid();
			String tmpuserpasswd=changePasswd( tmpui.getUserpasswd());
			if(tmpusername!=null &&tmpusername.equals(user.getUserid())) {
				hasusername=true;
				if(tmpuserpasswd!=null &&tmpuserpasswd.equals(user.getUserpasswd())) {
					hasuserpasswd=true;
					role=tmpui.getRole();
					user.setAge(tmpui.getAge());
					user.setGender(tmpui.getGender());
					user.setPhone(tmpui.getPhone());
					
					break;
				}
			}
		}
		
		System.out.println("找的role是:"+role);
		String result = null;
		if (hasusername) {
			if(hasuserpasswd) {
				user.setRole(role);
				
				if(role==0) {
					result = "success0";
				}else if(role==1) {
					result = "success1";
				}else {
					result = "success2";
				}
				
				
			}else{ 
				FacesMessage msg = new FacesMessage("登陆失败","密码错误");
				FacesContext.getCurrentInstance().addMessage("loginForm:login", msg);
			}
		}else {
			FacesMessage msg = new FacesMessage("登陆失败","用户名不存在");
			FacesContext.getCurrentInstance().addMessage("loginForm:login", msg);
		}
		return result;
	}
	//把用户信息读取到托管bean
	public void readUserInfo() {
		if(user.getUserid()==null) {
			user.setUserid("55170700");
		}
		List<Userinfo>datas=uid.findAllUserInfo();
		boolean found=false;
		for(int i=0;i<datas.size();i++) {
			Userinfo tmpui=datas.get(i);
			if(tmpui.getUserid()!=null && tmpui.getUserid().equals(user.getUserid())) {
				System.out.println("找到了");
				found=true;
				user.setAge(tmpui.getAge());
				user.setGender(tmpui.getGender());
				user.setPhone(tmpui.getPhone());
				user.setUserpasswd(changePasswd( tmpui.getUserpasswd()));
				user.setRole(tmpui.getRole());
				user.setId(tmpui.getId());
				break;
			}
		}
		if(!found) {
			System.out.println("没找到");
		}
		
	}
	
	//把bean中的信息更新保存到数据库
	public void changeUserInfo() {
		Userinfo uitmp=new Userinfo();
		uitmp.setAge(user.getAge());
		uitmp.setGender(user.getGender());
		uitmp.setId(user.getId());
		uitmp.setPhone(user.getPhone());
		uitmp.setRole(user.getRole());
		uitmp.setUserid(user.getUserid());
		uitmp.setUserpasswd(changePasswd1(user.getUserpasswd()));
		System.out.println("用户的密码"+uitmp.getUserpasswd());
		uid.modifyUserInfo(uitmp);
	}
	
	//把tmpbean中的信息更新到数据库
	public void changeTmpUserInfo() {
		Userinfo uitmp=new Userinfo();
		uitmp.setAge(tmpUserInfoBean.getAge());
		uitmp.setGender(tmpUserInfoBean.getGender());
		uitmp.setId(tmpUserInfoBean.getId());
		uitmp.setPhone(tmpUserInfoBean.getPhone());
		uitmp.setRole(tmpUserInfoBean.getRole());
		uitmp.setUserid(tmpUserInfoBean.getUserid());
		uitmp.setUserpasswd(changePasswd1( tmpUserInfoBean.getUserpasswd()));
		System.out.println(uitmp.getUserpasswd());
		uid.modifyUserInfo(uitmp);
	}

	//注销
	public void leave() {
		user.setAge(-1);
		user.setGender(-1);
		user.setId(0);
		user.setUserid(null);
		user.setUserpasswd(null);
		user.setPhone(null);
		user.setRole(-1);
	}
}
