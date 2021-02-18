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
import com.fuhao55170725.examsys.jsf.model.RankingBean;

@Named("rankingCtrl")
@RequestScoped
public class RankingCtrl {
	
	@Inject @Named("rankingBean")
	private RankingBean rb;
	
	@EJB
	private PaperStuDao psd;
	
	
	
	//显示排名信息
	public void setAll(ActionEvent event) {
		int paperid=(int)event.getComponent().getAttributes().get("paperid");	
		rb.setPaperid(paperid);
		System.out.println("paperid: "+paperid);
		List<PaperStu>paperstuDatas=psd.findAllPaperStu();
		List<Integer>idRes=new ArrayList<Integer>();
		List<Integer>gradeRes=new ArrayList<Integer>();
		for(int i=0;i<paperstuDatas.size();i++) {
			PaperStu psf=paperstuDatas.get(i);
			if(psf.getTestpaperid()==paperid) {
				idRes.add(psf.getStuid());
				gradeRes.add(psf.getGrade());
			}
		}
		while(true) {
			boolean ordered=true;
			for(int i=0; i<gradeRes.size()-1;i++) {
				if(gradeRes.get(i)-gradeRes.get(i+1)<0) {
					changeLoc(i,i+1,gradeRes,idRes);
					ordered=false;
				}
			}
			if(ordered) {
				break;
			}	
		}
		
		rb.setGrade(gradeRes);
		rb.setPaperid(paperid);
		rb.setUserid(idRes);
		System.out.println("gradesize: "+gradeRes.size());
		System.out.println("idsize: "+idRes.size());
		
		for(int i=0;i<gradeRes.size();i++) {
			System.out.println(idRes.get(i)+"+" +gradeRes.get(i));
		}
	}
	
	private void changeLoc(int a ,int b,List<Integer>list1,List<Integer>list2) {
		int tmp2,tmp1;
		tmp1=list1.get(a);
		list1.set(a, list1.get(b));
		list1.set(b, tmp1);
		
		tmp2=list2.get(a);
		list2.set(a, list2.get(b));
		list2.set(b, tmp2);
	}
}
