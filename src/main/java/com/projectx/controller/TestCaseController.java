package com.projectx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.helpers.LogLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.projectx.domain.TestCase;
import com.projectx.domain.TestCaseStatus;
import com.projectx.model.dao.StepDAO;
import com.projectx.model.dao.TestCaseDAO;
import com.projectx.model.dao.TestCaseStatusDAO;


public class TestCaseController extends MultiActionController{
	
	private TestCaseDAO testCaseDAO;
	private TestCaseStatusDAO testCaseStatusDAO;
	private StepDAO stepDAO;
	
	public ModelAndView list(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelMap modelMap = new ModelMap();
        /*
        LogLog.warn("here warn");
        LogLog.error("here error");
        */
        modelMap.addAttribute("testCaseList", testCaseDAO.listTestCase());
        modelMap.addAttribute("testCase", new TestCase());
        
        modelMap.addAttribute("testCaseStatusList", testCaseStatusDAO.listTestCaseStatus());
        modelMap.addAttribute("testCaseStatus", new TestCaseStatus());
        
        return new ModelAndView("testcase/view_test_case", modelMap);
    }
	
	public ModelAndView save(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelMap modelMap = new ModelMap();
        
        TestCase testCase = new TestCase();
       
        testCase.setDescription(request.getParameter("description"));
        testCase.setName(request.getParameter("name"));
        testCase.setFkTestCaseStatus(
        		new TestCaseStatus(Integer.parseInt(request.getParameter("fkTestCaseStatus"))));
        
        testCaseDAO.saveTestCase(testCase);
        
        modelMap.addAttribute("testCaseList", testCaseDAO.listTestCase());
        modelMap.addAttribute("testCase", new TestCase());
      
        
        return new ModelAndView("testcase/list_test_case", modelMap);
    }
	
	public ModelAndView delete(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelMap modelMap = new ModelMap();
        
        testCaseDAO.removeTestCaseById(Integer.parseInt(request.getParameter("id")));
        
        modelMap.addAttribute("testCaseList", testCaseDAO.listTestCase());
        modelMap.addAttribute("testCase", new TestCase());
      
        
        return new ModelAndView("testcase/list_test_case", modelMap);
    }
	
	public ModelAndView update(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		
		TestCase testCase = new TestCase();
		
		testCase.setId(Integer.parseInt(request.getParameter("id")));
		testCase.setName(request.getParameter("name"));
		testCase.setDescription(request.getParameter("description"));
		testCase.setFkTestCaseStatus(
				new TestCaseStatus(Integer.parseInt(request.getParameter("fkTestCaseStatus"))));
		testCaseDAO.updateTestCase(testCase);
		
		return null;
	}
	
	public ModelAndView find(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		ModelMap modelMap = new ModelMap();
		
		modelMap.addAttribute("testCaseDetail", testCaseDAO.
				getTestCaseByCriteria(Integer.parseInt(request.getParameter("id"))));
		
		modelMap.addAttribute("testCaseStatusList", testCaseStatusDAO.listTestCaseStatus());
        modelMap.addAttribute("testCaseStatus", new TestCaseStatus());
		
		return new ModelAndView("testcase/view_test_case_detail", modelMap);
	}
	
	//Test Case DAO
	public TestCaseDAO getTestCaseDAO() {
		return testCaseDAO;
	}

	public void setTestCaseDAO(TestCaseDAO testCaseDAO) {
		this.testCaseDAO = testCaseDAO;
	}
	//Test Case Status DAO 
	public TestCaseStatusDAO getTestCaseStatusDAO() {
		return testCaseStatusDAO;
	}

	public void setTestCaseStatusDAO(TestCaseStatusDAO testCaseStatusDAO) {
		this.testCaseStatusDAO = testCaseStatusDAO;
	}
	//Step DAO 
	public StepDAO getStepDAO() {
		return stepDAO;
	}

	public void setStepDAO(StepDAO stepDAO) {
		this.stepDAO = stepDAO;
	}

}
