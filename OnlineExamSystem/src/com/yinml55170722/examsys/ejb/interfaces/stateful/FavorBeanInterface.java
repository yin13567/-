package com.fuhao55170725.examsys.ejb.interfaces.stateful;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface FavorBeanInterface {
	
	public void addQueid(int queids);
	public List<Integer>getQueid();
	public List<String>getQueName();
	public List<String>getQueAns();
}
