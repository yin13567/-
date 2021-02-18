package com.fuhao55170725.examsys.ejb.interfaces.stateful;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import com.fuhao55170725.examsys.jpa.dao.QuestionDao;
import com.fuhao55170725.examsys.jpa.entity.Question;

@Stateful
public class FavorBeanCtrl implements FavorBeanInterface{
	
	@EJB
	private QuestionDao qd;
	
	
	List<Integer>queids;
	List<String>queName;
	List<String>queAns;
	
	@Override
	public void addQueid(int q) {
		// TODO 自动生成的方法存根
		this.queids.add( q);
		List<Question>queDatas=qd.findQuestion();
		for(int j=0;j<queids.size();j++) {
			int qeid=queids.get(j);
			for(int i=0;i<queDatas.size();i++) {
				Question tmpq=queDatas.get(i);
				if(qeid==tmpq.getId()) {
					queName.add(tmpq.getContent());
					queAns.add(tmpq.getAnswer());
				}
			}
		}
	}

	@Override
	public List<Integer> getQueid() {
		// TODO 自动生成的方法存根
		return this.queids;
	}

	@Override
	public List<String> getQueName() {
		// TODO 自动生成的方法存根
		return this.queName;
	}

	@Override
	public List<String> getQueAns() {
		// TODO 自动生成的方法存根
		return this.queAns;
	}

}
