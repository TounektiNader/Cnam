package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Centrecnam;

public interface CentrecnamService {
	

	public boolean  saveCentrecnam (Centrecnam ct)throws Exception;	
	public void  updateCentrecnam (Centrecnam ct )throws Exception;
	public void deleteCentrecnam (Centrecnam ct )throws Exception;
	public List <Centrecnam> findAllPers ()throws Exception; 
	public List <Centrecnam> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Centrecnam> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;



}
