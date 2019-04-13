package com.cnam.services;
import java.util.List;

import org.hibernate.criterion.Criterion;


import com.cnam.entity.Beneficiaire;

public interface BeneficiaireService {
	
	public boolean  saveBeneficiaire (Beneficiaire B)throws Exception;	
	public void  updateBeneficiaire (Beneficiaire B )throws Exception;
	public void deleteBeneficiaire (Beneficiaire B )throws Exception;
	public List <Beneficiaire> findAllPers ()throws Exception; 
	public List <Beneficiaire> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Beneficiaire> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;

}
