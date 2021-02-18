package com.fuhao55170725.examsys.jsf.ctrl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jms.AsyncMesConsumer;
import com.fuhao55170725.examsys.jsf.model.JmsBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("jmsCtrl")
@RequestScoped
public class JmsCtrl {
	@Inject @Named("jmsBean")
	private JmsBean jb;
	
	
	//接受订阅
	public void rec() {
		try {
			AsyncMesConsumer.main(null);
			 Thread.sleep(2000);
			jb.setContent(AsyncMesConsumer.getMsg());
			
			System.out.println("我看到的jms:"+jb.getContent());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
