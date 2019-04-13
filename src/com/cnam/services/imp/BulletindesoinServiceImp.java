package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.BulletindesoinDao;
import com.cnam.entity.Bulletindesoin;
import com.cnam.services.BulletindesoinService;

public class BulletindesoinServiceImp implements BulletindesoinService{
	
	
private BulletindesoinDao  bulletindesoinDao  ; 
	
	@Override
	public boolean saveBulletindesoin (Bulletindesoin bs) throws Exception {

		Criterion cr = Restrictions.eq("codBdeSoin", bs.getCodBdeSoin());
		boolean var = false;
		int codbs = findPersByCritertia(cr).size();
		

		if (codbs == 0) {
			bulletindesoinDao.save(bs);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateBulletindesoin(Bulletindesoin bs) throws Exception {
		
			bulletindesoinDao.save(bs);
			
	}

	@Override
	public void deleteBulletindesoin(Bulletindesoin bs) throws Exception {
		bulletindesoinDao.delete(bs);
	}

	@Override
	public List<Bulletindesoin> findAllPers() throws Exception {

		return bulletindesoinDao.findAll(Bulletindesoin.class);
	}

	@Override
	public List<Bulletindesoin> findPersByCritertia(Criterion cr) throws Exception {

		return bulletindesoinDao.findByCritertia(Bulletindesoin.class, cr);
	}

	@Override
	public List<Bulletindesoin> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return bulletindesoinDao.findByCritertia(Bulletindesoin.class, cr, cr2);
	}

	public BulletindesoinDao getBulletindesoinDao() {
		return bulletindesoinDao;
	}

	public void setBulletindesoinDao(BulletindesoinDao bulletindesoinDao) {
		this.bulletindesoinDao = bulletindesoinDao;
	}




}
