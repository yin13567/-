package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.QuestionDao;
import com.fuhao55170725.examsys.jpa.dao.QuestionsPaperDao;
import com.fuhao55170725.examsys.jpa.dao.TestPaperDao;
import com.fuhao55170725.examsys.jpa.entity.Question;
import com.fuhao55170725.examsys.jpa.entity.QuestionsPaper;
import com.fuhao55170725.examsys.jpa.entity.Testpaper;
import com.fuhao55170725.examsys.jsf.model.AllPaperBean;
import com.fuhao55170725.examsys.jsf.model.PurePaperBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("allPaperCtrl")
@RequestScoped
public class AllPaperCtrl {
	@Inject @Named("allPaperBean")
	private AllPaperBean apb;
	
	@Inject @Named("userInfoBean")
	private UserInfoBean user;
	
	@Inject @Named("purePaperBean")
	private PurePaperBean ppb;
	
	@EJB
	private TestPaperDao tpd;
	
	@EJB
	private QuestionsPaperDao qpd;
	
	@EJB
	private QuestionDao qd;
	
	//设置所有的信息
	public void setAllInfo() {
		if(user.getUserid()==null) {
			user.setId(2);
			user.setUserid("55170700");
		}
		List<String>nameRes=new ArrayList<String>();
		List<Integer>idRes=new ArrayList<Integer>();
		
		List<Testpaper>testpaperDatas=tpd.findAllTestPaper();
		for(int i=0;i<testpaperDatas.size();i++) {
			Testpaper tpmtf=testpaperDatas.get(i);
			if(tpmtf.getByuserid()==user.getId()) {
				nameRes.add(tpmtf.getName());
				idRes.add(tpmtf.getId());
			}
		}
		
		apb.setPapername(nameRes);
		apb.setPaperid(idRes);
		
		System.out.println("试卷管理");
		System.out.println("name size:"+nameRes.size());
		System.out.println("id size:"+idRes.size());
	}
	//设置显示的试卷信息
	public void setDetail(ActionEvent event) {
		int paperid=(int) event.getComponent().getAttributes().get("paperid");
		
		List<QuestionsPaper>questionpaperDatas=qpd.findAllQuestionsPaper();
		List<Question>questionDatas=qd.findQuestion();
		
		List<String>ques=new ArrayList<String>();
		List<String>ans=new ArrayList<String>();
		List<Integer>quesId=new ArrayList<Integer>();
		
		for(int i=0;i<questionpaperDatas.size();i++) {
			QuestionsPaper tmpqpf=questionpaperDatas.get(i);
			if(tmpqpf.getPaperid()==paperid) {
				quesId.add(tmpqpf.getQuestionid());
			}
		}
		for(int i=0;i<quesId.size();i++) {
			int tmpidf=quesId.get(i);
			for(int j=0;j<questionDatas.size();j++) {
				Question tmpqf=questionDatas.get(j);
				if(tmpqf.getId()==tmpidf) {
					ques.add(tmpqf.getContent());
					ans.add(tmpqf.getAnswer());
				}
			}
		}
		ppb.setAns(ans);
		ppb.setContent(ques);
		
		
	}
}
