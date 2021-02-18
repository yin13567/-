package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.CoursetableDao;
import com.fuhao55170725.examsys.jpa.dao.PaperStuDao;
import com.fuhao55170725.examsys.jpa.dao.TestPaperDao;
import com.fuhao55170725.examsys.jpa.entity.Coursetable;
import com.fuhao55170725.examsys.jpa.entity.PaperStu;
import com.fuhao55170725.examsys.jpa.entity.Testpaper;
import com.fuhao55170725.examsys.jsf.model.ExamdetailBean;
import com.fuhao55170725.examsys.jsf.model.UserExamInfoBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("userExamCtrl")
@RequestScoped
public class UserExamCtrl {
	@Inject @Named("userExamInfoBean")
	UserExamInfoBean ueib;
	
	@Inject @Named("userInfoBean")
	UserInfoBean user;
	
	@Inject @Named("examdetailBean")
	ExamdetailBean edb;
	
	@EJB
	private PaperStuDao psd;
	
	@EJB
	private TestPaperDao tpd;
	
	@EJB
	private CoursetableDao ctd;
	
	public void setAllCourseInfo() {
		if(user.getUserid()==null) {
			user.setUserid("123465");
			user.setId(1);
		}
		if(user.getId()==0) {
			user.setId(1);
		}
		List<PaperStu>PaperStuDatas=psd.findAllPaperStu();
		List<Testpaper>TestPaperDatas=tpd.findAllTestPaper();
		List<Coursetable> CoursetableDatas=ctd.findAllCoursetable();
		System.out.println("PaperStuSize:"+PaperStuDatas.size());
		System.out.println("TestPaperSize:"+TestPaperDatas.size());
		System.out.println("CoursetableSize:"+CoursetableDatas.size());
		List<Integer>fitPaperIds=new ArrayList<Integer>();
		List<String>fitPaperNames=new ArrayList<String>();
		List<Integer>fitCourseIds=new ArrayList<Integer>();
		List<String>fitCourseNames=new ArrayList<String>();
		
		for(int i=0;i<PaperStuDatas.size();i++) {
			PaperStu tmpps=PaperStuDatas.get(i);
			if(tmpps.getStuid()==user.getId()) {
				fitPaperIds.add(tmpps.getTestpaperid());
				for(int j=0;j<TestPaperDatas.size();j++) {
					if(TestPaperDatas.get(j).getId()==tmpps.getTestpaperid()) {
						fitPaperNames.add(TestPaperDatas.get(j).getName());
						fitCourseIds.add(TestPaperDatas.get(j).getBycourseid());
						for(int k=0;k<CoursetableDatas.size();k++) {
							if(CoursetableDatas.get(k).getId()==TestPaperDatas.get(j).getBycourseid()) {
								fitCourseNames.add(CoursetableDatas.get(k).getName());
							}
						}
					}
				}
			}
		}
		System.out.println("Userid: "+user.getId());
		System.out.println("PS size: "+PaperStuDatas.size());
		System.out.println("PID size: "+fitPaperIds.size());
		System.out.println("PName size: "+fitPaperNames.size());
		System.out.println("CID size: "+fitCourseIds.size());
		System.out.println("CName size: "+fitCourseNames.size());
		
		ueib.setCourseId(fitCourseIds);
		ueib.setCourseNames(fitCourseNames);
		ueib.setExamId(fitPaperIds);
		ueib.setExamNames(fitPaperNames);
		
	}

	public void startTest(ActionEvent event) {
		edb.setName("没有找到");
		edb.setContent("空");
		int dbpaperid=(int)event.getComponent().getAttributes().get("paperid");
		edb.setId(dbpaperid);
		List<Testpaper>testpaperDatas=tpd.findAllTestPaper();
		for(int i=0;i<testpaperDatas.size();i++) {
			Testpaper tmptpf=testpaperDatas.get(i);
			if(tmptpf.getId()==(int)dbpaperid) {
				//tmptp=tmptpf;
				edb.setName(tmptpf.getName());
				edb.setContent(tmptpf.getInfo());
				edb.setId(tmptpf.getId());
				break;
			}
		}
		
	}

	
}
