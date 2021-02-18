package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.PaperStuDao;
import com.fuhao55170725.examsys.jpa.dao.QuestionDao;
import com.fuhao55170725.examsys.jpa.dao.QuestionsPaperDao;
import com.fuhao55170725.examsys.jpa.dao.StuanDao;
import com.fuhao55170725.examsys.jpa.entity.PaperStu;
import com.fuhao55170725.examsys.jpa.entity.Question;
import com.fuhao55170725.examsys.jpa.entity.QuestionsPaper;
import com.fuhao55170725.examsys.jpa.entity.Stuan;
import com.fuhao55170725.examsys.jsf.model.PurePaperBean;
import com.fuhao55170725.examsys.jsf.model.StuansBean;

@Named("stuansCtrl")
@RequestScoped
public class StuansCtrl {
	@Inject @Named("stuansBean")
	private StuansBean sb;
	
	@Inject @Named("purePaperBean")
	private PurePaperBean ppbb;
	
	@EJB
	private StuanDao sd;
	
	@EJB
	private QuestionsPaperDao qpd;
	
	@EJB
	private QuestionDao qd;
	
	@EJB
	private PaperStuDao psd;
	
	//设置显示的学生试卷
	public void setAllInfo(ActionEvent event) {
		int sudid=(int)event.getComponent().getAttributes().get("stuid");	
		sb.setId(sudid);
		
		List<Integer>idRes=new ArrayList<Integer>();
		List<String>nameRes=new ArrayList<String>();
		
		List<Stuan>staansDatas=sd.findAllStuan();
		for(int i=0;i<staansDatas.size();i++) {
			Stuan tmpstf=staansDatas.get(i);
			if(tmpstf.getPaperid()==sb.getPaperid()&&tmpstf.getStuid()==sb.getId()) {
				idRes.add(tmpstf.getQuesid());
				nameRes.add(tmpstf.getAns());
			}
		}
		
		sb.setQueid(idRes);
		sb.setStuans(nameRes);
		//设置试卷
		List<QuestionsPaper>qpDatas=qpd.findAllQuestionsPaper();
		List<Question>qDatas=qd.findQuestion();
		
		
		List<Integer>questionId=new ArrayList<Integer>();
		List<String>queRes=new ArrayList<String>();
		List<String>ansRes=new ArrayList<String>();
		
		for(int i=0;i<qpDatas.size();i++) {
			QuestionsPaper tmpqpf=qpDatas.get(i);
			if(tmpqpf.getPaperid()==sb.getPaperid()) {
				questionId.add(tmpqpf.getQuestionid());
			}
		}
		for(int i=0;i<questionId.size();i++) {
			int qeuidf=questionId.get(i);
			for(int j=0;j<qDatas.size();j++) {
				Question quef=qDatas.get(j);
				if(quef.getId()==qeuidf) {
					queRes.add(quef.getContent());
					ansRes.add(quef.getAnswer());
				}
			}
		}
		
		ppbb.setContent(queRes);
		ppbb.setAns(ansRes);
	}
	//打分
	public void setGrade() {
		int paperid=sb.getPaperid();
		int userid=sb.getId();
		double grade=sb.getGrade();
		int incid=0;
		List<PaperStu>psDatas=psd.findAllPaperStu();
		for(int i=0;i<psDatas.size();i++) {
			PaperStu psf=psDatas.get(i);
			if(psf.getId()==userid && psf.getStuid()==userid) {
				incid=psf.getId();
			}
		}
		PaperStu psn=new PaperStu();
		psn.setGrade((int)grade);
		psn.setId(incid);
		psn.setStuid(userid);
		psn.setTestpaperid(paperid);
		psd.modifyPaperStu(psn);
	}
}
