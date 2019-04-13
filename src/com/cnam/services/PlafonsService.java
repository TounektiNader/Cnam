package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Plafons;

public interface PlafonsService {
	public boolean  savePlafons (Plafons P)throws Exception;	
	public void updatePlafons (Plafons P )throws Exception;
	public void deletePlafons (Plafons P )throws Exception;
	public List <Plafons> findAllPers ()throws Exception; 
	public List <Plafons> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Plafons> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;


}
