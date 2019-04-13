package com.cnam.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import com.cnam.dao.GenericDao;
import com.cnam.utils.HibernateUtil;

public class GenericDaoImp implements GenericDao {
	private Session hibernateSession;
	private Transaction tx;

	@Override
	public void save(Object entity) {
		startoperation();
		hibernateSession.saveOrUpdate(entity);
		endoperation();
	}

	@Override
	public void delete(Object entity) {
		startoperation();
		hibernateSession.delete(entity);
		endoperation();
	}

	@Override
	public List findAll(Class cls) {

		startoperation();
		List list = hibernateSession.createCriteria(cls).list();
		endoperation();
		return list;
	}

	@Override
	public List findByCritertia(Class cls, Criterion cr) {

		startoperation();
		List list = hibernateSession.createCriteria(cls).add(cr).list();
		endoperation();
		return list;
	}

	protected void startoperation() {
		hibernateSession = HibernateUtil.currentSession();
		tx = hibernateSession.beginTransaction();

	}

	protected void endoperation() {
		tx.commit();
		hibernateSession.close();

	}

	@Override
	public List findByCritertia(Class cls, Criterion cr, Criterion cr2) throws Exception {
		startoperation();
		List list = hibernateSession.createCriteria(cls).add(cr).add(cr2).list();
		endoperation();
		return list;
		
	}

}