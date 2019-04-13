package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.BsvistDao;
import com.cnam.entity.Bsvisit;
import com.cnam.services.BsvistService;

public class BsvisitServiceImp implements BsvistService{
	
private BsvistDao  bsvistDao  ; 
	
	@Override
	public boolean saveBsvisit (Bsvisit vi) throws Exception {

		Criterion cr = Restrictions.eq("codVisit", vi.getCodVisit());
		boolean var = false;
		int codvisit = findPersByCritertia(cr).size();
		

		if (codvisit == 0) {
			bsvistDao.save(vi);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateBsvisit(Bsvisit vi) throws Exception {
					bsvistDao.save(vi);
		
	}

	@Override
	public void deleteBsvisit(Bsvisit vi) throws Exception {
		bsvistDao.delete(vi);
	}

	@Override
	public List<Bsvisit> findAllPers() throws Exception {

		return bsvistDao.findAll(Bsvisit.class);
	}

	@Override
	public List<Bsvisit> findPersByCritertia(Criterion cr) throws Exception {

		return bsvistDao.findByCritertia(Bsvisit.class, cr);
	}

	@Override
	public List<Bsvisit> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return bsvistDao.findByCritertia(Bsvisit.class, cr, cr2);
	}

	public BsvistDao getBsvisitDao() {
		return bsvistDao;
	}

	public void setBsvisitDao(BsvistDao bsvistDao) {
		this.bsvistDao = bsvistDao;
	}


}
