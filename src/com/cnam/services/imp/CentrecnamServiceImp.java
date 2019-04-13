package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.CentrecnamDao;
import com.cnam.entity.Centrecnam;
import com.cnam.services.CentrecnamService;

public class CentrecnamServiceImp implements CentrecnamService {
	
private CentrecnamDao  centrecnamDao  ; 
	
	@Override
	public boolean saveCentrecnam (Centrecnam ct) throws Exception {

		Criterion cr = Restrictions.eq("codeCnam", ct.getCodeCnam());
		boolean var = false;
		int codcnam = findPersByCritertia(cr).size();
		

		if (codcnam == 0) {
			centrecnamDao.save(ct);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateCentrecnam(Centrecnam ct) throws Exception {
					centrecnamDao.save(ct);
		
	}

	@Override
	public void deleteCentrecnam(Centrecnam ct) throws Exception {
		centrecnamDao.delete(ct);
	}

	@Override
	public List<Centrecnam> findAllPers() throws Exception {

		return centrecnamDao.findAll(Centrecnam.class);
	}

	@Override
	public List<Centrecnam> findPersByCritertia(Criterion cr) throws Exception {

		return centrecnamDao.findByCritertia(Centrecnam.class, cr);
	}

	@Override
	public List<Centrecnam> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return centrecnamDao.findByCritertia(Centrecnam.class, cr, cr2);
	}

	public CentrecnamDao getCentrecnamDao() {
		return centrecnamDao;
	}

	public void setCentrecnamDao(CentrecnamDao centrecnamDao) {
		this.centrecnamDao = centrecnamDao;
	}



}
