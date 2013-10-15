package com.projectx.model.dao;

import java.util.List;

import com.projectx.domain.TestCase;

public interface TestCaseDAO {
	
	public void saveTestCase(TestCase testCase);
    
    public void updateTestCase(TestCase testCase);
    
    public void removeTestCaseById(int testCaseId);

    public List<TestCase> listTestCase();    
    
    public TestCase getTestCaseByCriteria(int testCaseId);

}
