package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.ChangementDao;
import com.cnam.entity.Changement;
import com.cnam.services.ChangementService;

public class ChangementServiceImp implements ChangementService {
	
	
private ChangementDao  changementDao  ; 
	
	@Override
	public boolean saveChangement (Changement ch) throws Exception {

		Criterion cr = Restrictions.eq("idChangement", ch.getIdChangement());
		boolean var = false;
		int id = findPersByCritertia(cr).size();
		

		if (id == 0) {
			changementDao.save(ch);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateChangement(Changement ch) throws Exception {
		
			changementDao.save(ch);
			}

	@Override
	public void deleteChangement(Changement ch) throws Exception {
		changementDao.delete(ch);
	}

	@Override
	public List<Changement> findAllPers() throws Exception {

		return changementDao.findAll(Changement.class);
	}

	@Override
	public List<Changement> findPersByCritertia(Criterion cr) throws Exception {

		return changementDao.findByCritertia(Changement.class, cr);
	}

	@Override
	public List<Changement> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return changementDao.findByCritertia(Changement.class, cr, cr2);
	}

	public ChangementDao getChangementDao() {
		return changementDao;
	}

	public void setChangementDao(ChangementDao changementDao) {
		this.changementDao = changementDao;
	}



}
