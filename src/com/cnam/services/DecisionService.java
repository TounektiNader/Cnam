package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Decision;

public interface DecisionService {
	public boolean  saveDecision (Decision D)throws Exception;	
	public void  updateDecision (Decision D )throws Exception;
	public void deleteDecision (Decision D )throws Exception;
	public List <Decision> findAllPers ()throws Exception; 
	public List <Decision> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Decision> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;


}
