package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Utilisateur;

public interface UtilisateurService {
	public boolean  saveUtilisateur (Utilisateur U)throws Exception;	
	public void  updateUtilisateur (Utilisateur U )throws Exception;
	public void deleteUtilisateur (Utilisateur U )throws Exception;
	public List <Utilisateur> findAllPers ()throws Exception; 
	public List <Utilisateur> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Utilisateur> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;

}
