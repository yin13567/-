package com.fuhao55170725.examsys.jsf.biz;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.fuhao55170725.examsys.jpa.dao.UserInfoDao;
import com.fuhao55170725.examsys.jpa.entity.Userinfo;


@FacesValidator("usernameValidator")
public class UsernameValidator implements Validator {

	@EJB
	private UserInfoDao uid;
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO 自动生成的方法存根
		String username=(String)arg2;
		List<Userinfo>uiDatas=uid.findAllUserInfo();
		
		for(int i=0;i<uiDatas.size();i++) {
			Userinfo tmpuif=uiDatas.get(i);
			if(tmpuif.getUserid().equals(username) ){
				FacesMessage msg = new FacesMessage("注册失败","用户名重复,请重新输入");
				throw new ValidatorException(msg);
			}
		}
		
	}

	

}
