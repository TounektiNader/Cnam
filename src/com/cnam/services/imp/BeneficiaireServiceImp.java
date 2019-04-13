package com.cnam.services.imp;


import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;


import com.cnam.dao.BeneficiaireDao;

import com.cnam.entity.Beneficiaire;
import com.cnam.services.BeneficiaireService;

public class BeneficiaireServiceImp implements BeneficiaireService {
	private  BeneficiaireDao beneficiaireDao;

	@Override
	public boolean saveBeneficiaire(Beneficiaire B) throws Exception {

		Criterion cr = Restrictions.eq("codeBenef", B.getCodeBenef());
		boolean var = false;
		int codeBenf = findPersByCritertia(cr).size();
		

		if (codeBenf == 0) {
			beneficiaireDao.save(B);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateBeneficiaire(Beneficiaire B) throws Exception {
					beneficiaireDao.save(B); 
					}
		
				
		

	@Override
	public void deleteBeneficiaire(Beneficiaire B) throws Exception {
		beneficiaireDao.delete(B);
	}

	@Override
	public List<Beneficiaire> findAllPers() throws Exception {

		return beneficiaireDao.findAll(Beneficiaire.class);
	}

	@Override
	public List<Beneficiaire> findPersByCritertia(Criterion cr) throws Exception {

		return beneficiaireDao.findByCritertia(Beneficiaire.class, cr);
	}

	@Override
	public List<Beneficiaire> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return beneficiaireDao.findByCritertia(Beneficiaire.class, cr, cr2);
	}

	public BeneficiaireDao getBeneficiaireDao() {
		return beneficiaireDao;
	}

	public void setBeneficiaireDao(BeneficiaireDao beneficiaireDao) {
		this.beneficiaireDao = beneficiaireDao;
	}

}
