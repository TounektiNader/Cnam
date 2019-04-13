package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Prestataire;

public interface PrestataireService {
	
	public boolean  savePrestataire (Prestataire pr)throws Exception;	
	public void  updatePrestataire (Prestataire pr )throws Exception;
	public void deletePrestataire (Prestataire Pr )throws Exception;
	public List <Prestataire> findAllPers ()throws Exception; 
	public List <Prestataire> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Prestataire> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;


}
