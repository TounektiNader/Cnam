package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Changement;

public interface ChangementService {
	
	public boolean  saveChangement (Changement ch)throws Exception;	
	public void  updateChangement (Changement ch )throws Exception;
	public void deleteChangement (Changement ch )throws Exception;
	public List <Changement> findAllPers ()throws Exception; 
	public List <Changement> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Changement> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;



}
