package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.services.AssureService;
import com.cnam.dao.AssureDao;
import com.cnam.entity.Assuresociale;
import com.cnam.dao.imp.AssureDaoImp;

public class AssureServiceImp implements AssureService{
	private  AssureDao assureDao;
	
	@Override
	public boolean saveAssure(Assuresociale A) throws Exception {

		Criterion cr = Restrictions.eq("matriculeAssure", A.getMatriculeAssure());
		boolean var = false;
		int nbmat = findPersByCritertia(cr).size();
		

		if (nbmat == 0) {
			assureDao.save(A);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateAssure(Assuresociale A) throws Exception {
					assureDao.save(A);
			}

	@Override
	public void deleteAssure(Assuresociale A) throws Exception {
		assureDao.delete(A);
	}

	@Override
	public List<Assuresociale> findAllPers() throws Exception {

		return assureDao.findAll(Assuresociale.class);
	}

	@Override
	public List<Assuresociale> findPersByCritertia(Criterion cr) throws Exception {

		return assureDao.findByCritertia(Assuresociale.class, cr);
	}

	@Override
	public List<Assuresociale> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return assureDao.findByCritertia(Assuresociale.class, cr, cr2);
	}

	public AssureDao getAssureDao() {
		return assureDao;
	}

	public void setAssureDao(AssureDao assureDao) {
		this.assureDao = assureDao;
	}

}



