package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.PersonalquestionbankDao;
import com.fuhao55170725.examsys.jpa.dao.QuestionDao;
import com.fuhao55170725.examsys.jpa.dao.QuestionPersonalDao;
import com.fuhao55170725.examsys.jpa.entity.Personalquestionbank;
import com.fuhao55170725.examsys.jpa.entity.Question;
import com.fuhao55170725.examsys.jpa.entity.QuestionPersonal;
import com.fuhao55170725.examsys.jsf.model.PersonalbankquesionBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("personalbankquesionCtrl")
@RequestScoped
public class PersonalbankquesionCtrl {
	@Inject @Named("userInfoBean")
	private UserInfoBean user;
	
	@Inject @Named("personalbankquesionBean")
	private PersonalbankquesionBean pb;
	
	@EJB
	private PersonalquestionbankDao  pqbd;
	
	@EJB
	private QuestionDao  qd;
	
	@EJB
	private QuestionPersonalDao qpd;
	
	//设置所有的信息
	public void setAllInfo() {
		if(user.getUserid()==null) {
			user.setUserid("55170700");
			user.setId(2);
		}
		List<String>contentRes=new ArrayList<String>();
		List<String>ansRes=new ArrayList<String>();
		
		List<Integer>quesIds=new ArrayList<Integer>();
		List<Personalquestionbank>perquebankDatas=pqbd.findAllPersonalquestionbank();
		List<Question>quesDatas=qd.findQuestion();
		List<QuestionPersonal> queperDatas=qpd.findAllQuestionPersonal();
		
		int bankid=0;
		for(int i=0;i<perquebankDatas.size();i++) {
			Personalquestionbank tmppf=perquebankDatas.get(i);
			if(tmppf.getUserid()==user.getId()) {
				bankid=tmppf.getId();
				break;
			}
		}
		
		for(int i=0;i<queperDatas.size();i++) {
			QuestionPersonal tmpqpf=queperDatas.get(i);
			if(tmpqpf.getBankid()==bankid) {
				quesIds.add(tmpqpf.getQuestionId());
			}
		}
		
		for(int i=0;i<quesIds.size();i++) {
			int ids=quesIds.get(i);
			for(int j=0;j<quesDatas.size();j++) {
				Question tmpqf=quesDatas.get(j);
				if(tmpqf.getId()==ids) {
					contentRes.add(tmpqf.getContent());
					ansRes.add(tmpqf.getAnswer());
				}
			}
		}
		
		pb.setAns(ansRes);
		pb.setContent(contentRes);
		
		
	}
}
