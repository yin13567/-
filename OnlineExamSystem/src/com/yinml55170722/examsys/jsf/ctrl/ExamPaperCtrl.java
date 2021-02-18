package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.QuestionDao;
import com.fuhao55170725.examsys.jpa.dao.StuanDao;
import com.fuhao55170725.examsys.jpa.entity.Question;
import com.fuhao55170725.examsys.jpa.entity.Stuan;
import com.fuhao55170725.examsys.jsf.model.ExamPaperBean;
import com.fuhao55170725.examsys.jsf.model.ExamdetailBean;
@Named("examPaperCtrl")
@RequestScoped
public class ExamPaperCtrl {
	
	@Inject @Named("examPaperBean")
	private ExamPaperBean epb;
	
	@Inject @Named("examdetailBean")
	ExamdetailBean edb;
	
	@EJB
	private QuestionDao qd;
	
	@EJB
	private StuanDao sd;
	//设置信息
	public void setAll(ActionEvent event) {
		int queid=(int)event.getComponent().getAttributes().get("quesid");
		int paperid=edb.getId();
		epb.setQueid(queid);
		List<Question>queDatas=qd.findQuestion();
		List<Stuan>stuanDatas=sd.findAllStuan();
		for(int i=0;i<queDatas.size();i++) {
			Question tmpqf=queDatas.get(i);
			if(tmpqf.getId()==queid) {
				String quesName=tmpqf.getContent();
				epb.setQue(quesName);
			}
		}
		
		for(int i=0;i<stuanDatas.size();i++) {
			Stuan tmpstf=stuanDatas.get(i);
			if(tmpstf.getPaperid()==paperid && tmpstf.getQuesid()==queid) {
				epb.setAns(tmpstf.getAns());
			}
		}
		
	}
}
