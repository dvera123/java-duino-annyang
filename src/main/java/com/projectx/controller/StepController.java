package com.projectx.controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.projectx.model.dao.StepDAO;

public class StepController extends MultiActionController{
	
	private StepDAO stepDAO;

	public StepDAO getStepDAO() {
		return stepDAO;
	}

	public void setStepDAO(StepDAO stepDAO) {
		this.stepDAO = stepDAO;
	}
	
	

}
