package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.PaperStuDao;
import com.fuhao55170725.examsys.jpa.entity.PaperStu;
import com.fuhao55170725.examsys.jsf.model.PaperlistBean;
import com.fuhao55170725.examsys.jsf.model.PurePaperBean;
import com.fuhao55170725.examsys.jsf.model.StuansBean;

@Named("paperlistCtrl")
@RequestScoped
public class PaperlistCtrl {
	
	@Inject @Named("paperlistBean")
	private PaperlistBean pb;
	
	@Inject @Named("stuansBean")
	private StuansBean sb;
	
	@Inject @Named("purePaperBean")
	private PurePaperBean ppbb;
	
	@EJB
	private PaperStuDao psd;
	
	//设置所有信息
	public void setAll(ActionEvent event) {
		List<PaperStu>paperstuDatas=psd.findAllPaperStu();
		pb.setId(0);
		int paperid=(int)event.getComponent().getAttributes().get("paperid");
		pb.setId(paperid);
		pb.setStuid(null);
		sb.setPaperid(paperid);
		ppbb.setQueid(paperid);
		
		List<Integer>stdidRes=new ArrayList<Integer>();
		for(int i=0;i<paperstuDatas.size();i++) {
			PaperStu tmppsf=paperstuDatas.get(i);
			if(tmppsf.getTestpaperid()==paperid) {
				stdidRes.add(tmppsf.getStuid());
			}
		}
		pb.setStuid(stdidRes);	
		System.out.println("试卷的id:"+paperid);
		System.out.println("数目:"+stdidRes.size());
	}
}
