package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.TestPaperDao;
import com.fuhao55170725.examsys.jpa.entity.Testpaper;
import com.fuhao55170725.examsys.jsf.model.PaperteaBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("paperteaCtrl")
@RequestScoped
public class PaperteaCtrl {
	@Inject @Named("paperteaBean")
	private PaperteaBean ptb;
	
	@Inject @Named("userInfoBean")
	UserInfoBean user;
	
	@EJB
	private TestPaperDao tpd;
	
	//设置所有的信息
	public void setAllInfo() {
		if(user.getUserid()==null) {
			user.setId(2);
			user.setUserid("55170700");
		}
		ptb.setPaperid(null);
		ptb.setPaperNames(null);
		
		List<Integer>idRes=new ArrayList<Integer>();
		List<String>nameRes=new ArrayList<String>();
		
		List<Testpaper>testpaperDatas=tpd.findAllTestPaper();
		for(int i=0;i<testpaperDatas.size();i++) {
			Testpaper tmptf=testpaperDatas.get(i);
			if(tmptf.getByuserid()==user.getId()) {
				idRes.add(tmptf.getId());
				nameRes.add(tmptf.getName());
			}
		}
		
		ptb.setPaperid(idRes);
		ptb.setPaperNames(nameRes);
		
	}
}
