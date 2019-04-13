package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Filiere;

public interface FiliereService {
	
	public boolean  saveFiliere (Filiere fi)throws Exception;	
	public void  updateFiliere (Filiere fi )throws Exception;
	public void deleteFiliere (Filiere fi )throws Exception;
	public List <Filiere> findAllPers ()throws Exception; 
	public List <Filiere> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Filiere> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;


}
