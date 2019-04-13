package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Assuresociale;

public interface AssureService {
	public boolean  saveAssure (Assuresociale A)throws Exception;	
	public void updateAssure (Assuresociale A )throws Exception;
	public void deleteAssure (Assuresociale A )throws Exception;
	public List <Assuresociale> findAllPers ()throws Exception; 
	public List <Assuresociale> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Assuresociale> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;

}
