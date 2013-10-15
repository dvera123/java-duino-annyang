package com.projectx.model.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.projectx.domain.TestCase;
import com.projectx.domain.TestCaseStatus;
import com.projectx.model.dao.TestCaseDAO;
import com.projectx.util.HibernateUtil;

public class TestCaseDAOImpl implements TestCaseDAO{

	Session session = HibernateUtil.getSessionFactory().openSession();
	
	@Override
	public void saveTestCase(TestCase testCase) {
		Transaction tr = null;
        tr = session.beginTransaction();
        session.saveOrUpdate(testCase);
        tr.commit();
		
	}

	@Override
	public void updateTestCase(TestCase testCase) {
		Transaction tr = null;
        tr = session.beginTransaction();

        //session.saveOrUpdate(testCase);

        TestCase tc = (TestCase) session.get(TestCase.class,testCase.getId());
        tc.setName(testCase.getName());
        tc.setDescription(testCase.getDescription());
        tc.setFkTestCaseStatus(testCase.getFkTestCaseStatus());
        session.update(tc);

        tr.commit();
		
	}

	@Override
	public void removeTestCaseById(int testCaseId) {
		Transaction tr = null;
        tr = session.beginTransaction();
        Object tc = session.get(TestCase.class,testCaseId);
        session.delete(tc);
        tr.commit();
		
	}

	@Override
	public List<TestCase> listTestCase() {
		//session.flush();
		Query qr = session.getNamedQuery("TestCase.findAll");
        return qr.list();
	}

	@Override
	public TestCase getTestCaseByCriteria(int testCaseId) {
		// TODO This is not a method to get a Test Case by any criteria, 
		// this is just working for id parameter.
		Query qr = session.getNamedQuery("TestCase.findById");
        qr.setParameter("id", testCaseId);
        List l = qr.list();
        return (TestCase) l.get(0);
	}

}
