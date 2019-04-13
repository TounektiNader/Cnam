package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.ReclamationDao;
import com.cnam.entity.Reclamation;
import com.cnam.services.ReclamationService;

public class ReclamationServiceImp implements ReclamationService{
private ReclamationDao  reclamationDao  ; 
	
	@Override
	public boolean saveReclamation (Reclamation R) throws Exception {

		Criterion cr = Restrictions.eq("id", R.getId());
		boolean var = false;
		int idR = findPersByCritertia(cr).size();
		

		if (idR== 0) {
			reclamationDao.save(R);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public boolean updateReclamation(Reclamation R) throws Exception {
		boolean var = false;
		Criterion cr = Restrictions.eq("id", R.getId());
		int idR = findPersByCritertia(cr).size();

		if (idR == 0) {
			reclamationDao.save(R);
			var = true;
		} else {
           
		Criterion cr2 = Restrictions.eq("id",R.getId())	;
		int nb = findPersByCritertia(cr,cr2).size();
		if (nb==1){
			reclamationDao.save(R);
			var = true;
			
		}
				
		}
		return var;
	}

	@Override
	public void deleteReclamation(Reclamation R) throws Exception {
		reclamationDao.delete(R);
	}

	@Override
	public List<Reclamation> findAllPers() throws Exception {

		return reclamationDao.findAll(Reclamation.class);
	}

	@Override
	public List<Reclamation> findPersByCritertia(Criterion cr) throws Exception {

		return reclamationDao.findByCritertia(Reclamation.class, cr);
	}

	@Override
	public List<Reclamation> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return reclamationDao.findByCritertia(Reclamation.class, cr, cr2);
	}

	public ReclamationDao getReclamationDao() {
		return reclamationDao;
	}

	public void setReclamationDao(ReclamationDao reclamationDao) {
		this.reclamationDao = reclamationDao;
	}


	


}
