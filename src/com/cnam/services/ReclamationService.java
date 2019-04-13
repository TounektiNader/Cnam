package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Reclamation;

public interface ReclamationService {
	
	public boolean  saveReclamation (Reclamation R)throws Exception;	
	public boolean  updateReclamation (Reclamation R )throws Exception;
	public void deleteReclamation (Reclamation R )throws Exception;
	public List <Reclamation> findAllPers ()throws Exception; 
	public List <Reclamation> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Reclamation> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;



}
