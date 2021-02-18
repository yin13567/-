package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jms.AsyncMesConsumer;
import com.fuhao55170725.examsys.jpa.dao.CoursetableDao;
import com.fuhao55170725.examsys.jpa.dao.NoticetableDao;
import com.fuhao55170725.examsys.jpa.dao.PaperStuDao;
import com.fuhao55170725.examsys.jpa.dao.TestPaperDao;
import com.fuhao55170725.examsys.jpa.dao.UserInfoDao;
import com.fuhao55170725.examsys.jpa.entity.Coursetable;
import com.fuhao55170725.examsys.jpa.entity.Noticetable;
import com.fuhao55170725.examsys.jpa.entity.PaperStu;
import com.fuhao55170725.examsys.jpa.entity.Testpaper;
import com.fuhao55170725.examsys.jpa.entity.Userinfo;
import com.fuhao55170725.examsys.jsf.model.RecNotificationBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("recNotificationCtrl")
@RequestScoped
public class RecNotificationCtrl {
	
	@Inject @Named("userInfoBean")
	private UserInfoBean user;
	
	@Inject @Named("recNotificationBean")
	private RecNotificationBean rnb;
	
	@EJB
	private PaperStuDao psd;
	
	@EJB 
	private CoursetableDao cd;
	
	@EJB
	private TestPaperDao tpd;
	
	@EJB 
	private NoticetableDao nd;
	
	
	
	//设置所有的信息
	public void setAllInfo() {
		List<String>nameRes = new ArrayList<String>();
		List<String>pubRes = new ArrayList<String>();
		List<String>contentRes=new ArrayList<String>();
		List<String>timeRes=new ArrayList<String>();
		
		if(user.getUserid()==null) {
			user.setUserid("123465");
			user.setId(1);
		}
		if(user.getId()==0) {
			user.setId(1);
		}
		List<PaperStu>paperstuDatas=psd.findAllPaperStu();
		List<Coursetable>coursetableDatas=cd.findAllCoursetable();
		List<Testpaper>testpaperDatas=tpd.findAllTestPaper();
		List<Noticetable>noticetableDatas=nd.findAllNoticetable();
		
		for(int i=0;i<paperstuDatas.size();i++) {
			PaperStu tmppsf=paperstuDatas.get(i);
			int stuid=tmppsf.getStuid();
			if(stuid==user.getId()) {
				int paperid=tmppsf.getTestpaperid();
				for(int j=0;j<testpaperDatas.size();j++) {
					Testpaper tmptpf=testpaperDatas.get(j);
					int paperidf=tmptpf.getId();
					if(paperid==paperidf) {
						int courseid=tmptpf.getBycourseid();
						String coursename="";
						for(int k=0;k<coursetableDatas.size();k++) {
							Coursetable tmpcf=coursetableDatas.get(k);
							coursename=tmpcf.getName();			
						}
						for(int l=0;l<noticetableDatas.size();l++) {
							Noticetable tmpntf=noticetableDatas.get(l);
							int courseidf=tmpntf.getFromcourse();
							if(courseidf==courseid) {
								String contentf=tmpntf.getContent();
								String timef=tmpntf.getPubtime().toString();
								int useridf=tmpntf.getByuserid();
								
								nameRes.add(coursename);
								pubRes.add(String.valueOf(useridf));
								contentRes.add(contentf);
								timeRes.add(timef);
							}
						}
					}
				}
			}
		}
		rnb.setContent(contentRes);
		rnb.setCoursename(nameRes);
		rnb.setPubuser(pubRes);
		rnb.setTime(timeRes);
		System.out.println("课程名称数目:"+nameRes.size());
		System.out.println("课程内容数目:"+contentRes.size());
		System.out.println("课程时间数目:"+timeRes.size());
		System.out.println("课程发布人数目:"+pubRes.size());
		
		
	}
}
