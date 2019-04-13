package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.PrestataireDao;
import com.cnam.entity.Prestataire;
import com.cnam.services.PrestataireService;

public class PrestataireServiceImp implements PrestataireService {
private PrestataireDao  prestataireDao  ; 
	
	@Override
	public boolean savePrestataire (Prestataire pr) throws Exception {

		Criterion cr = Restrictions.eq("matriculePrestataire", pr.getMatriculePrestataire());
		boolean var = false;
		int matPrest = findPersByCritertia(cr).size();
		

		if (matPrest== 0) {
			prestataireDao.save(pr);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updatePrestataire(Prestataire pr) throws Exception {
					prestataireDao.save(pr);
		
	}

	@Override
	public void deletePrestataire(Prestataire pr) throws Exception {
		prestataireDao.delete(pr);
	}

	@Override
	public List<Prestataire> findAllPers() throws Exception {

		return prestataireDao.findAll(Prestataire.class);
	}

	@Override
	public List<Prestataire> findPersByCritertia(Criterion cr) throws Exception {

		return prestataireDao.findByCritertia(Prestataire.class, cr);
	}

	@Override
	public List<Prestataire> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return prestataireDao.findByCritertia(Prestataire.class, cr, cr2);
	}

	public PrestataireDao getPrestataireDao() {
		return prestataireDao;
	}

	public void setPrestataireDao(PrestataireDao prestataireDao) {
		this.prestataireDao = prestataireDao;
	}





}
