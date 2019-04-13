package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Facture;

public interface FactureService {
	
	public boolean  saveFacture (Facture F)throws Exception;	
	public void  updateFacture (Facture F )throws Exception;
	public void deleteFacture (Facture F )throws Exception;
	public List <Facture> findAllPers ()throws Exception; 
	public List <Facture> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Facture> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;


}
