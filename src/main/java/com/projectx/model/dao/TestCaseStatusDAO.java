package com.projectx.model.dao;

import java.util.List;

import com.projectx.domain.TestCaseStatus;

public interface TestCaseStatusDAO {
	
	public void saveTestCaseStatus(TestCaseStatus testCaseStatus);
    
    public void updateTestCase(TestCaseStatus testCaseStatus);
    
    public void removeTestCaseStatusById(int testCaseStatusId);

    public List<TestCaseStatus> listTestCaseStatus();    
    
    public TestCaseStatus getTestCaseStatusByCriteria(int testCaseStatusId);

}
