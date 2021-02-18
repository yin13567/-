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
import com.fuhao55170725.examsys.jpa.dao.StuanDao;
import com.fuhao55170725.examsys.jpa.dao.TestPaperDao;
import com.fuhao55170725.examsys.jpa.entity.Question;
import com.fuhao55170725.examsys.jpa.entity.QuestionsPaper;
import com.fuhao55170725.examsys.jpa.entity.Stuan;
import com.fuhao55170725.examsys.jpa.entity.Testpaper;
import com.fuhao55170725.examsys.jsf.model.ExamPaperBean;
import com.fuhao55170725.examsys.jsf.model.ExamdetailBean;
import com.fuhao55170725.examsys.jsf.model.ExaminfoBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("examdetailCtrl")
@RequestScoped
public class ExamdetailCtrl {
	@Inject @Named("examdetailBean")
	private ExamdetailBean edb;
	
	@Inject @Named("examPaperBean")
	private ExamPaperBean epb;
	
	@Inject @Named("userInfoBean")
	UserInfoBean user;
	
	@EJB
	private QuestionsPaperDao qpd;
	
	@EJB
	private QuestionDao qd;
	
	@EJB
	private TestPaperDao tpd;
	
	@EJB
	private StuanDao sd;
	
	public void startTest(ActionEvent event) {
		epb.setName(edb.getName());
		int dbpaperid=(int)event.getComponent().getAttributes().get("courseid");
		
		List<Integer>quesList=new ArrayList<Integer>(100);
		List<String>tk=new ArrayList<String>(100);
		List<String>xz=new ArrayList<String>(100);
		List<String>pd=new ArrayList<String>(100);
		List<String>wd=new ArrayList<String>(100);
		List<Integer>tkId=new ArrayList<Integer>(100);
		List<Integer>xzId=new ArrayList<Integer>(100);
		List<Integer>pdId=new ArrayList<Integer>(100);
		List<Integer>wdId=new ArrayList<Integer>(100);
		List<String>tkAns=new ArrayList<String>(100);
		List<String>xzAns=new ArrayList<String>(100);
		List<String>pdAns=new ArrayList<String>(100);
		List<String>wdAns=new ArrayList<String>(100);
		
		List<QuestionsPaper> questionsPaperDatas=qpd.findAllQuestionsPaper();
		List<Question>questionDatas=qd.findQuestion();
		
		for(int i=0;i<questionsPaperDatas.size();i++) {
			QuestionsPaper tmpqpf=questionsPaperDatas.get(i);
			if(tmpqpf.getPaperid()==(int)dbpaperid) {
				quesList.add(tmpqpf.getQuestionid());
			}
		}
		for(int i=0;i<quesList.size();i++) {
			int select=quesList.get(i);
			for(int j=0;j<questionDatas.size();j++) {
				Question tmpqf=questionDatas.get(j);
				if(tmpqf.getId()==select) {
					int kind=tmpqf.getKind();
					switch(kind) {
					case 0:{
						tk.add(tmpqf.getContent());
						tkId.add(tmpqf.getId());
						tkAns.add(new String());
						break;
					}
					case 1:{
						xz.add(tmpqf.getContent());
						xzId.add(tmpqf.getId());
						xzAns.add(new String());
						break;
					}
					case 2:{
						pd.add(tmpqf.getContent());
						pdId.add(tmpqf.getId());
						pdAns.add(new String());
						break;
					}
					case 3:{
						wd.add(tmpqf.getContent());
						wdId.add(tmpqf.getId());
						wdAns.add(new String());
						break;
					}
					}
				}
			}
		}
		
		//设置到bean中
		epb.setPanduan(pd);
		epb.setTiankong(tk);
		epb.setWenda(wd);
		epb.setXuanze(xz);
		
		epb.setPanduanAns(pdAns);
		epb.setTiankongAns(tkAns);
		epb.setWendaAns(wdAns);
		epb.setXuanzeAns(xzAns);
		
		epb.setPanduanId(pdId);
		epb.setTiankongId(tkId);
		epb.setWendaId(wdId);
		epb.setXuanzeId(xzId);	
	}

	public void endTest(ActionEvent event) {
		if(user.getUserid()==null) {
			user.setUserid("123465");
			user.setId(1);
		}
		if(user.getId()==0) {
			user.setId(1);
		}
		

		Stuan stuan=new Stuan();
		stuan.setQuesid(epb.getQueid());
		stuan.setAns(epb.getAns());
		stuan.setPaperid(edb.getId());
		stuan.setStuid(user.getId());
		stuan.setGrade(0);
		
		List<Stuan>stuanDatas=sd.findAllStuan();
		boolean found=false;
		for(int i=0;i<stuanDatas.size();i++) {
			Stuan tmpstf=stuanDatas.get(i);
			if(tmpstf.getPaperid()==stuan.getPaperid() && tmpstf.getQuesid()==stuan.getQuesid()) {
				stuan.setId(tmpstf.getId());
				sd.modifyStuan(stuan);
				found=true;
				break;
			}
		}
			
		if(!found) {
			sd.addStuan(stuan);
		}
	}

	public void setQuesList() {
		
	}
}
