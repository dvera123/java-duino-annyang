package com.projectx.model.dao;

import java.util.List;

import com.projectx.domain.Step;

public interface StepDAO {
	
	public void saveStep(Step step);
    
    public void updateStep(Step step);
    
    public void removeStepById(int stepId);

    public List<Step> listStep();    
    
    public Step getStepByCriteria(int stepId);

}
