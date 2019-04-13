package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.FactureDao;
import com.cnam.entity.Facture;
import com.cnam.services.FactureService;

public class FactureServiceImp  implements FactureService{

private FactureDao  factureDao  ; 
	
	@Override
	public boolean saveFacture (Facture F) throws Exception {

		Criterion cr = Restrictions.eq("referFacture", F.getReferFacture());
		boolean var = false;
		int ref = findPersByCritertia(cr).size();
		

		if (ref== 0) {
			factureDao.save(F);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateFacture(Facture F) throws Exception {
					factureDao.save(F);
				
		
	}

	@Override
	public void deleteFacture(Facture F) throws Exception {
		factureDao.delete(F);
	}

	@Override
	public List<Facture> findAllPers() throws Exception {

		return factureDao.findAll(Facture.class);
	}

	@Override
	public List<Facture> findPersByCritertia(Criterion cr) throws Exception {

		return factureDao.findByCritertia(Facture.class, cr);
	}

	@Override
	public List<Facture> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return factureDao.findByCritertia(Facture.class, cr, cr2);
	}

	public FactureDao getFactureDao() {
		return factureDao;
	}

	public void setFactureDao(FactureDao factureDao) {
		this.factureDao = factureDao;
	}




}
