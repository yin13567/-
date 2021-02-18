package com.fuhao55170725.examsys.jsf.ctrl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.QuestionDao;
import com.fuhao55170725.examsys.jpa.dao.QuestionsPaperDao;
import com.fuhao55170725.examsys.jpa.dao.TestPaperDao;
import com.fuhao55170725.examsys.jpa.entity.Question;
import com.fuhao55170725.examsys.jpa.entity.QuestionsPaper;
import com.fuhao55170725.examsys.jpa.entity.Testpaper;
import com.fuhao55170725.examsys.jsf.model.CourseBean;
import com.fuhao55170725.examsys.jsf.model.CourseteaBean;
import com.fuhao55170725.examsys.jsf.model.PaperBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("paperCtrl")
@RequestScoped
public class PaperCtrl {
	
	@Inject @Named("courseteaBean")
	private CourseteaBean ctb;
	
	@Inject @Named("paperBean")
	private PaperBean pb;
	
	@Inject @Named("userInfoBean")
	private UserInfoBean user;
	
	@EJB
	private QuestionDao qd;
	
	@EJB
	private TestPaperDao tpd;
	
	@EJB
	private QuestionsPaperDao qpd;
	
	//排序算法
	private double[] sortD(double[] datas){
		double[]res=new double[datas.length];
		for(int i=0;i<datas.length;i++) {
			res[i]=datas[i];
		}
		while(true) {
			boolean ordered=true;
			for(int i=0;i<res.length-1;i++) {
				if(res[i]-res[i+1]>0) {
					double tmp=res[i];
					res[i]=res[i+1];
					res[i+1]=tmp;
					ordered=false;
				}
			}
			if(ordered) {break;}
		}
		return res;
	}
	//从数组中找到第一个数字的位置
	private int findIndex(double[]list, double num) {
		for(int i=0;i<list.length;i++) {
			if(list[i]-num==0) {
				return i;
			}
		}
		return -1;
	}
	/*
	private int[] genRandom(int bign,int smalln) {//从0到bign-1中产生smalln的随机数
		double[]randomFloat=new double[bign];
		int[]res=new int[smalln];
		for(int i=0;i<bign;i++) {
			randomFloat[i] = Math.random();
		}
		double[] sorteddata=sortD(randomFloat);
		for(int i=0;i<smalln;i++) {
			res[i]=findIndex(randomFloat,sorteddata[i]);
		}
		return res;
	}*/
	
	private List<Integer>genRandom(int bign,int smalln){
		double[]randomFloat=new double[bign];
		List<Integer>res=new ArrayList<Integer>();
		for(int i=0;i<bign;i++) {
			randomFloat[i] = Math.random();
		}
		double[] sorteddata=sortD(randomFloat);
		for(int i=0;i<smalln;i++) {
			res.add(findIndex(randomFloat,sorteddata[i]));
		}
		return res;
	}
	private List<Integer>genRandom(int smalln,List<Integer>list){
		int bign=list.size();
		double[]randomFloat=new double[bign];
		List<Integer>res=new ArrayList<Integer>();
		for(int i=0;i<bign;i++) {
			randomFloat[i] = Math.random();
		}
		double[] sorteddata=sortD(randomFloat);
		for(int i=0;i<smalln;i++) {
			res.add(list.get(findIndex(randomFloat,sorteddata[i])));
		}
		return res;
	}
	
	//产生试卷
	public void setQues() {
		List<Integer>ids=pb.getBankIds();
		int num=pb.getNum();
		
		List<Integer>idres=genRandom(num,ids);
		List<String>contentRes=new ArrayList<String>();
		List<String>ansRes=new ArrayList<String>();
		
		System.out.print("产生试卷的随机号码如下:");
		for(int i=0;i<idres.size();i++) {
			System.out.print(idres.get(i)+" ");
		}
		System.out.println();
		
		List<Question>questionDatas=qd.findQuestion();
		for(int i=0;i<idres.size();i++) {
			int quesid=idres.get(i);
			for(int j=0;j<questionDatas.size();j++) {
				Question tmpqf=questionDatas.get(j);
				if(tmpqf.getId()==quesid) {
					contentRes.add(tmpqf.getContent());
					ansRes.add(tmpqf.getAnswer());
				}
			}
		}
		pb.setQuesIds(idres);
		pb.setQuesAns(ansRes);
		pb.setQuesContent(contentRes);
	}
	//把试卷存入数据库
	public void savePaper() {
		if(user.getUserid()==null) {
			user.setId(2);
			user.setUserid("55170700");
		}
		int userid=user.getId();
		int courseid=ctb.getSelectid();
		float timepaper=pb.getPaperTime();
		String name=pb.getPaperName();
		String intro=pb.getPaperIntro();
		Testpaper tpn=new Testpaper();
		
		
		
		tpn.setBycourseid(courseid);
		tpn.setByuserid(userid);
		tpn.setInfo(intro);
		tpn.setName(name);
		Date date=new Date();
		Timestamp timeStap=new Timestamp(date.getTime());
		tpn.setStarttime(timeStap);
		date.setTime(date.getTime()+(long)(timepaper*60*60*1000));
		Timestamp timeStap1=new Timestamp(date.getTime());
		tpn.setEndtime(timeStap1);
		System.out.println("试卷信息如下:");
		System.out.println(userid);
		System.out.println(courseid);
		System.out.println(name);
		System.out.println(intro);
		System.out.println(timeStap);
		tpd.addTestPaper(tpn);
		
		List<Testpaper>testpaperDatas=tpd.findAllTestPaper();
		int newpaperid=0;
		for(int i=0;i<testpaperDatas.size();i++) {
			Testpaper tmptf=testpaperDatas.get(i);
			if(tmptf.getName()!=null&& tmptf.getName().equals(name)) {
				newpaperid=tmptf.getId();
			}
		}
		
		List<Integer>qids=pb.getQuesIds();
		for(int i=0;i<qids.size();i++) {
			int qidf=qids.get(i);
			QuestionsPaper tmpqpf=new QuestionsPaper();
			tmpqpf.setGrade(0);
			tmpqpf.setQuestionid(qidf);
			tmpqpf.setPaperid(newpaperid);
			qpd.addQuestionsPaper(tmpqpf);
		}
		
	}
}
