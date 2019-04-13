package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Priseencharge;

public interface PriseenchargeService {
	
	public boolean  savePriseencharge (Priseencharge pc)throws Exception;	
	public void  updatePriseencharge (Priseencharge pc )throws Exception;
	public void deletePriseencharge (Priseencharge Pc )throws Exception;
	public List <Priseencharge> findAllPers ()throws Exception; 
	public List <Priseencharge> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Priseencharge> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;


}
