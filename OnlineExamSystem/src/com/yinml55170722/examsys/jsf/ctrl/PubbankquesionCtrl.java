package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.ejb.interfaces.stateful.FavorBeanInterface;
import com.fuhao55170725.examsys.jpa.dao.CoursetableDao;
import com.fuhao55170725.examsys.jpa.dao.PersonalquestionbankDao;
import com.fuhao55170725.examsys.jpa.dao.QuestionDao;
import com.fuhao55170725.examsys.jpa.dao.QuestionPersonalDao;
import com.fuhao55170725.examsys.jpa.entity.Coursetable;
import com.fuhao55170725.examsys.jpa.entity.Personalquestionbank;
import com.fuhao55170725.examsys.jpa.entity.Question;
import com.fuhao55170725.examsys.jpa.entity.QuestionPersonal;
import com.fuhao55170725.examsys.jsf.model.CourseBean;
import com.fuhao55170725.examsys.jsf.model.PubbankquesionBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("pubbankquesionCtrl")
@RequestScoped
public class PubbankquesionCtrl {

	@Inject @Named("pubbankquesionBean")
    private	PubbankquesionBean pqb;
	
	@Inject @Named("courseBean")
	private CourseBean cb;
	
	@Inject @Named("userInfoBean")
	UserInfoBean user;
	
	@EJB
	private QuestionDao qd;
	
	@EJB
	private CoursetableDao cd;
	
	@EJB
	private PersonalquestionbankDao pd;
	
	@EJB
	private QuestionPersonalDao qpd;
	
	@EJB
	private FavorBeanInterface fbi;
	
	//设置显示题库中所有的题目
	public void setAllInfo() {
		List<Integer>questionId=new ArrayList<Integer>();
		List<String>questionContent=new ArrayList<String>();
		
		List<Question>questionDatas=qd.findQuestion();
		List<Coursetable>coursetableDatas=cd.findAllCoursetable();
		int selectCourseid=cb.getSelectId();
		for(int i=0;i<questionDatas.size();i++) {
			Question tmpqf=questionDatas.get(i);
			if(tmpqf.getQb()==selectCourseid) {
				questionId.add(tmpqf.getId());
				questionContent.add(tmpqf.getContent());
				
			}
		}
		String coursename="";
		for(int i=0;i<coursetableDatas.size();i++) {
			if(coursetableDatas.get(i).getId()==selectCourseid) {
				coursename=coursetableDatas.get(i).getQuestionbankName();
			}
		}
		
		pqb.setBankname(coursename);
		pqb.setQuestioncontent(questionContent);
		pqb.setQuestionid(questionId);
	}
	//收藏题目
	public void addFavor(ActionEvent event) {
		int queid=(int)event.getComponent().getAttributes().get("queid");
		if(user.getUserid()==null) {
			user.setUserid("55170700");
			user.setId(2);
		}
		int bankid=0;
		List<Personalquestionbank> perbankDatas=pd.findAllPersonalquestionbank();
		List<QuestionPersonal>questionpersonalDatas=qpd.findAllQuestionPersonal();
		
		
		boolean found=false;
		for(int i=0;i<perbankDatas.size() && !found;i++) {
			Personalquestionbank tmppf=perbankDatas.get(i);
			if(tmppf.getUserid()==user.getId()) {
				bankid=tmppf.getId();
				found=true;
				break;
			}
			if(i==(perbankDatas.size()-1) && !found) {
				Personalquestionbank tmppfn=new Personalquestionbank();
				tmppfn.setUserid(user.getId());
				tmppfn.setName(user.getId()+"的个人题库");
				pd.addPersonalquestionbank(tmppfn);
				
				i=-1;
				
			}
		}
		
		QuestionPersonal tmpqpn=new QuestionPersonal();
		tmpqpn.setBankid(bankid);
		tmpqpn.setQuestionId(queid);
		
		qpd.addQuestionPersonal(tmpqpn);
		
		
		//设置bean
		fbi.addQueid(queid);
		
	}
}
