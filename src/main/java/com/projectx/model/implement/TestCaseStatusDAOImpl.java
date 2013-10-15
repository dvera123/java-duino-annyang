package com.projectx.model.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.projectx.domain.TestCaseStatus;
import com.projectx.model.dao.TestCaseStatusDAO;
import com.projectx.util.HibernateUtil;

public class TestCaseStatusDAOImpl implements TestCaseStatusDAO{
	
	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void saveTestCaseStatus(TestCaseStatus testCaseStatus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTestCase(TestCaseStatus testCaseStatus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTestCaseStatusById(int testCaseStatusId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TestCaseStatus> listTestCaseStatus() {
		Query qr = session.getNamedQuery("TestCaseStatus.findAll");
        return qr.list();
	}

	@Override
	public TestCaseStatus getTestCaseStatusByCriteria(int testCaseStatusId) {
		// TODO Auto-generated method stub
		return null;
	}

}
