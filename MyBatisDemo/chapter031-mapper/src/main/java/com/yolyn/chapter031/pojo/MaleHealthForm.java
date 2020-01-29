package com.yolyn.chapter031.pojo;

import lombok.ToString;

@ToString
public class MaleHealthForm extends HealthForm {
	
	private String prostate;

	public String getProstate() {
		return prostate;
	}

	public void setProstate(String prostate) {
		this.prostate = prostate;
	}
	
}
