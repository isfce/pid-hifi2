package org.isfce.pid.hifi;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

public class Tuner implements ISource, BeanNameAware, DisposableBean {
	private String nom;

	@Override
	public String getMusic() {
		return "Radio 21";
	}

	@Override
	public void setBeanName(String name) {
		nom = name;
		System.out.println("Mon nom est: " + name);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Bye bye : " + nom);
	}

}
