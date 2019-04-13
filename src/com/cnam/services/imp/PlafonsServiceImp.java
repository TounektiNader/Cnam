package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.PlafonsDao;
import com.cnam.entity.Plafons;
import com.cnam.services.PlafonsService;

public class PlafonsServiceImp implements PlafonsService{
	
private PlafonsDao  plafonsDao  ; 
	
	@Override
	public boolean savePlafons (Plafons P) throws Exception {

		Criterion cr = Restrictions.eq("codPlafonds", P.getCodPlafonds());
		boolean var = false;
		int codpla = findPersByCritertia(cr).size();
		

		if (codpla== 0) {
			plafonsDao.save(P);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updatePlafons(Plafons P) throws Exception {
	
			plafonsDao.save(P);
			
	}

	@Override
	public void deletePlafons(Plafons P) throws Exception {
		plafonsDao.delete(P);
	}

	@Override
	public List<Plafons> findAllPers() throws Exception {

		return plafonsDao.findAll(Plafons.class);
	}

	@Override
	public List<Plafons> findPersByCritertia(Criterion cr) throws Exception {

		return plafonsDao.findByCritertia(Plafons.class, cr);
	}

	@Override
	public List<Plafons> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return plafonsDao.findByCritertia(Plafons.class, cr, cr2);
	}

	public PlafonsDao getPlafonsDao() {
		return plafonsDao;
	}

	public void setPlafonsDao(PlafonsDao plafonsDao) {
		this.plafonsDao = plafonsDao;
	}




}
