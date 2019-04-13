package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.FiliereDao;
import com.cnam.entity.Filiere;
import com.cnam.services.FiliereService;

public class FiliereServiceImp  implements FiliereService{
private FiliereDao  filiereDao  ; 
	
	@Override
	public boolean saveFiliere (Filiere fi) throws Exception {

		Criterion cr = Restrictions.eq("codFiliere", fi.getCodFiliere());
		boolean var = false;
		int codfil = findPersByCritertia(cr).size();
		

		if (codfil== 0) {
			filiereDao.save(fi);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateFiliere(Filiere fi) throws Exception {
	
			filiereDao.save(fi);
			
	
	}

	@Override
	public void deleteFiliere(Filiere fi) throws Exception {
		filiereDao.delete(fi);
	}

	@Override
	public List<Filiere> findAllPers() throws Exception {

		return filiereDao.findAll(Filiere.class);
	}

	@Override
	public List<Filiere> findPersByCritertia(Criterion cr) throws Exception {

		return filiereDao.findByCritertia(Filiere.class, cr);
	}

	@Override
	public List<Filiere> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return filiereDao.findByCritertia(Filiere.class, cr, cr2);
	}

	public FiliereDao getFiliereDao() {
		return filiereDao;
	}

	public void setFiliereDao(FiliereDao filiereDao) {
		this.filiereDao = filiereDao;
	}




}
