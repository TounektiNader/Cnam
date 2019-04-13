package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.PriseenchargeDao;
import com.cnam.entity.Priseencharge;
import com.cnam.services.PriseenchargeService;

public class PriseenchargeServiceImp  implements PriseenchargeService{
	
private PriseenchargeDao  priseenchargeDao  ; 
	
	@Override
	public boolean savePriseencharge (Priseencharge pc) throws Exception {

		Criterion cr = Restrictions.eq("codDpe", pc.getCodDpe());
		boolean var = false;
		int codDpe = findPersByCritertia(cr).size();
		

		if (codDpe== 0) {
			priseenchargeDao.save(pc);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updatePriseencharge(Priseencharge pc) throws Exception {
					priseenchargeDao.save(pc);
			}

	@Override
	public void deletePriseencharge(Priseencharge pc) throws Exception {
		priseenchargeDao.delete(pc);
	}

	@Override
	public List<Priseencharge> findAllPers() throws Exception {

		return priseenchargeDao.findAll(Priseencharge.class);
	}

	@Override
	public List<Priseencharge> findPersByCritertia(Criterion cr) throws Exception {

		return priseenchargeDao.findByCritertia(Priseencharge.class, cr);
	}

	@Override
	public List<Priseencharge> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return priseenchargeDao.findByCritertia(Priseencharge.class, cr, cr2);
	}

	public PriseenchargeDao getPriseenchargeDao() {
		return priseenchargeDao;
	}

	public void setPriseenchargeDao(PriseenchargeDao priseenchargeDao) {
		this.priseenchargeDao = priseenchargeDao;
	}


	

}
