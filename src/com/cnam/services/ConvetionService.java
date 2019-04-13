package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Convention;

public interface ConvetionService {
	public boolean saveConvention (Convention Cn)throws Exception;	
	public void  updateConvention (Convention Cn )throws Exception;
	public void deleteConvention (Convention Cn )throws Exception;
	public List <Convention> findAllPers ()throws Exception; 
	public List <Convention> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Convention> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;



}
