package com.cnam.services.imp;


import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;


import com.cnam.dao.BsmedicamentDao;
import com.cnam.entity.Bsmedicament;
import com.cnam.services.BsmedicamentService;

public class BsmedicamentServiceImp implements BsmedicamentService {
	private BsmedicamentDao bsmedicamentDao ; 
	
	@Override
	public boolean saveBsmedicament (Bsmedicament med) throws Exception {

		Criterion cr = Restrictions.eq("numSeq", med.getNumSeq());
		boolean var = false;
		int nums = findPersByCritertia(cr).size();
		

		if (nums == 0) {
			bsmedicamentDao.save(med);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateBsmedicament(Bsmedicament med) throws Exception {
					bsmedicamentDao.save(med);
		
	}

	@Override
	public void deleteBsmedicament(Bsmedicament med) throws Exception {
		bsmedicamentDao.delete(med);
	}

	@Override
	public List<Bsmedicament> findAllPers() throws Exception {

		return bsmedicamentDao.findAll(Bsmedicament.class);
	}

	@Override
	public List<Bsmedicament> findPersByCritertia(Criterion cr) throws Exception {

		return bsmedicamentDao.findByCritertia(Bsmedicament.class, cr);
	}

	@Override
	public List<Bsmedicament> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return bsmedicamentDao.findByCritertia(Bsmedicament.class, cr, cr2);
	}

	public BsmedicamentDao getBsmedicamentDao() {
		return bsmedicamentDao;
	}

	public void setBsmedicamentDao(BsmedicamentDao bsmedicamentDao) {
		this.bsmedicamentDao = bsmedicamentDao;
	}


}
