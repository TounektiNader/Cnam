package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.BsacteDao;
import com.cnam.entity.Bsacte;
import com.cnam.services.BsacteService;
import com.cnam.dao.imp.BsacteDaoImp;

public class BsacteServiceImp implements BsacteService{
private BsacteDao bsacteDao;
	
	@Override
	public boolean savebsacte(Bsacte ac) throws Exception {

		Criterion cr = Restrictions.eq("codActe", ac.getCodActe());
		boolean var = false;
		int codeacte = findPersByCritertia(cr).size();
		

		if (codeacte == 0) {
			bsacteDao.save(ac);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updatebsacte(Bsacte ac) throws Exception {
				bsacteDao.save(ac);
	
	}

	@Override
	public void deletebsacte(Bsacte ac) throws Exception {
		bsacteDao.delete(ac);
	}

	@Override
	public List<Bsacte> findAllPers() throws Exception {

		return bsacteDao.findAll(Bsacte.class);
	}

	@Override
	public List<Bsacte> findPersByCritertia(Criterion cr) throws Exception {

		return bsacteDao.findByCritertia(Bsacte.class, cr);
	}

	@Override
	public List<Bsacte> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return bsacteDao.findByCritertia(Bsacte.class, cr, cr2);
	}

	public BsacteDao getBsacteDao() {
		return bsacteDao;
	}

	public void setBsacteDao(BsacteDao bsacteDao) {
		this.bsacteDao = bsacteDao;
	}

}
