package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.QuestionDao;
import com.fuhao55170725.examsys.jpa.entity.Question;
import com.fuhao55170725.examsys.jsf.model.PaperBean;
import com.fuhao55170725.examsys.jsf.model.QuelistBean;

@Named("quelistCtrl")
@RequestScoped
public class QuelistCtrl {
	
	@Inject @Named("quelistBean")
	private QuelistBean qb;
	
	@EJB
	private QuestionDao qd;
	//设置所有的信息
	public void setAll(ActionEvent event) {
		
		List<Integer>qesidRes=new ArrayList<Integer>();
		List<String>quesRes=new ArrayList<String>();
		
		List<Question>queDatas=qd.findQuestion();
		int paperid=(int)event.getComponent().getAttributes().get("courseid");
		qb.setPaperid(paperid);
		for(int i=0;i<queDatas.size();i++) {
			Question tmpqf=queDatas.get(i);
			if(tmpqf.getQb()==paperid) {
				qesidRes.add(tmpqf.getId());
				quesRes.add(tmpqf.getContent());
			}
		}
		
		qb.setContents(quesRes);
		qb.setIds(qesidRes);
	}
}
