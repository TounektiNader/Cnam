package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.ConventionDao;
import com.cnam.entity.Convention;
import com.cnam.services.ConvetionService;

public class ConvetionServiceImp implements ConvetionService {
private ConventionDao  conventionDao  ; 
	
	@Override
	public boolean saveConvention (Convention Cn) throws Exception {

		Criterion cr = Restrictions.eq("codConv", Cn.getCodConv());
		boolean var = false;
		int codConv = findPersByCritertia(cr).size();
		

		if (codConv == 0) {
			conventionDao.save(Cn);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateConvention(Convention Cn) throws Exception {
		
			conventionDao.save(Cn);
	
	}

	@Override
	public void deleteConvention(Convention Cn) throws Exception {
		conventionDao.delete(Cn);
	}

	@Override
	public List<Convention> findAllPers() throws Exception {

		return conventionDao.findAll(Convention.class);
	}

	@Override
	public List<Convention> findPersByCritertia(Criterion cr) throws Exception {

		return conventionDao.findByCritertia(Convention.class, cr);
	}

	@Override
	public List<Convention> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return conventionDao.findByCritertia(Convention.class, cr, cr2);
	}

	public ConventionDao getConventionDao() {
		return conventionDao;
	}

	public void setConventionDao(ConventionDao conventionDao) {
		this.conventionDao = conventionDao;
	}




}
