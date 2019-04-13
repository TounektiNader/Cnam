package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.CnamsDao;
import com.cnam.entity.Cnams;
import com.cnam.services.CnamsService;

public class CnamsServiceImp implements CnamsService {

private CnamsDao  cnamsDao  ; 
	
	@Override
	public boolean saveCnams (Cnams cn) throws Exception {

		Criterion cr = Restrictions.eq("id", cn.getId());
		boolean var = false;
		int id = findPersByCritertia(cr).size();
		

		if (id == 0) {
			cnamsDao.save(cn);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateCnams(Cnams cn) throws Exception {
		
			cnamsDao.save(cn);
	
	}

	@Override
	public void deleteCnams(Cnams cn) throws Exception {
		cnamsDao.delete(cn);
	}

	@Override
	public List<Cnams> findAllPers() throws Exception {

		return cnamsDao.findAll(Cnams.class);
	}

	@Override
	public List<Cnams> findPersByCritertia(Criterion cr) throws Exception {

		return cnamsDao.findByCritertia(Cnams.class, cr);
	}

	@Override
	public List<Cnams> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return cnamsDao.findByCritertia(Cnams.class, cr, cr2);
	}

	public CnamsDao getCnamsDao() {
		return cnamsDao;
	}

	public void setCnamsDao(CnamsDao cnamsDao) {
		this.cnamsDao = cnamsDao;
	}



}
