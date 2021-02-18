package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.PaperStuDao;
import com.fuhao55170725.examsys.jpa.dao.TestPaperDao;
import com.fuhao55170725.examsys.jpa.entity.PaperStu;
import com.fuhao55170725.examsys.jpa.entity.Testpaper;
import com.fuhao55170725.examsys.jsf.model.UserGradeBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("userGradeCtrl")
@RequestScoped
public class UserGradeCtrl {
	@Inject @Named("userGradeBean")
	UserGradeBean ugb;
	@Inject @Named("userInfoBean")
	UserInfoBean user;
	
	@EJB
	PaperStuDao psd;
	@EJB
	TestPaperDao tpd;
	
	
	//设置所有的用户成绩信息
	public void setAllUserGrade() {
		if(user.getUserid()==null) {
			user.setUserid("123465");
			user.setId(1);
		}
		List<PaperStu>paperStuDatas=psd.findAllPaperStu();
		List<Testpaper>testpaperDatas=tpd.findAllTestPaper();
		
		List<String>name=new ArrayList<String>();
		List<Integer>paperid=new ArrayList<Integer>();
		List<Integer>grade=new ArrayList<Integer>();
		//List<Integer>ranking=new ArrayList<Integer>();
		for(int i=0;i<paperStuDatas.size();i++) {
			PaperStu tmppsf=paperStuDatas.get(i);
			if(tmppsf.getStuid()==user.getId()) {
				paperid.add(tmppsf.getTestpaperid());
				grade.add(tmppsf.getGrade());		
			}
		}
		for(int i=0;i<paperid.size();i++) {
			for(int j=0;j<testpaperDatas.size();j++) {
				if(testpaperDatas.get(j).getId()==paperid.get(i)) {
					name.add(testpaperDatas.get(j).getName());
				}
			}
		}
		System.out.println(grade.size());
		System.out.println(name.size());
		ugb.setGrade(grade);
		ugb.setName(name);
	}
}
