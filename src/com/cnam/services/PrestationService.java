package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Prestation;

public interface PrestationService {
	public boolean  savePrestation (Prestation ps)throws Exception;	
	public void  updatePrestation (Prestation ps )throws Exception;
	public void deletePrestation (Prestation Ps )throws Exception;
	public List <Prestation> findAllPers ()throws Exception; 
	public List <Prestation> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Prestation> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;


}
