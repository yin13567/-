package com.fuhao55170725.examsys.jsf.biz;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.fuhao55170725.examsys.jpa.entity.Userinfo;
@FacesValidator("loginValidator")
public class LoginValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO 自动生成的方法存根
		String passwd=(String)arg2;
		
		//验证密码
		if(passwd.length()<8) {
			FacesMessage msg = new FacesMessage("注册失败","密码至少8位");
			throw new ValidatorException(msg);
		}
		for(int i=0;i<passwd.length();i++) {
			char c=passwd.charAt(i);
			if(!((c>='0'&&c<='9')||(c>='a'&&c<='z')||(c>='A'&&c<='Z'))) {
				FacesMessage msg = new FacesMessage("注册失败","请输入数字或字母");
				throw new ValidatorException(msg);
			}
		}
		boolean hasN=false;
		boolean hasC=false;
		for(int i=0;i<passwd.length();i++) {
			char c=passwd.charAt(i);
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
			throw new ValidatorException(msg);
		}
		
	}

}
