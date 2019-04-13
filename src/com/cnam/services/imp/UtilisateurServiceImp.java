package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.UtilisateurDao;
import com.cnam.entity.Utilisateur;
import com.cnam.services.UtilisateurService;

public class UtilisateurServiceImp implements UtilisateurService {
	
	
private UtilisateurDao  utilisateurDao  ; 
	
	@Override
	public boolean saveUtilisateur (Utilisateur U) throws Exception {

		Criterion cr = Restrictions.eq("codUser", U.getCodUser());
		boolean var = false;
		int codUser = findPersByCritertia(cr).size();
		

		if (codUser== 0) {
			utilisateurDao.save(U);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateUtilisateur(Utilisateur U) throws Exception {
		
					utilisateurDao.save(U);
		
	}

	@Override
	public void deleteUtilisateur(Utilisateur U) throws Exception {
		utilisateurDao.delete(U);
	}

	@Override
	public List<Utilisateur> findAllPers() throws Exception {

		return utilisateurDao.findAll(Utilisateur.class);
	}

	@Override
	public List<Utilisateur> findPersByCritertia(Criterion cr) throws Exception {

		return utilisateurDao.findByCritertia(Utilisateur.class, cr);
	}

	@Override
	public List<Utilisateur> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return utilisateurDao.findByCritertia(Utilisateur.class, cr, cr2);
	}

	public UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}





}
