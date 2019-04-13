package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.PrestationDao;
import com.cnam.entity.Prestation;
import com.cnam.services.PrestationService;

public class PrestationServiceImp implements PrestationService{
	
private PrestationDao  prestationDao  ; 
	
	@Override
	public boolean savePrestation (Prestation ps) throws Exception {

		Criterion cr = Restrictions.eq("codPrestation", ps.getCodPrestation());
		boolean var = false;
		int codPres = findPersByCritertia(cr).size();
		

		if (codPres== 0) {
			prestationDao.save(ps);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updatePrestation(Prestation ps) throws Exception {
					prestationDao.save(ps);
		
	}

	@Override
	public void deletePrestation(Prestation ps) throws Exception {
		prestationDao.delete(ps);
	}

	@Override
	public List<Prestation> findAllPers() throws Exception {

		return prestationDao.findAll(Prestation.class);
	}

	@Override
	public List<Prestation> findPersByCritertia(Criterion cr) throws Exception {

		return prestationDao.findByCritertia(Prestation.class, cr);
	}

	@Override
	public List<Prestation> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return prestationDao.findByCritertia(Prestation.class, cr, cr2);
	}

	public PrestationDao getPrestationDao() {
		return prestationDao;
	}

	public void setPrestationDao(PrestationDao prestationDao) {
		this.prestationDao = prestationDao;
	}


}
