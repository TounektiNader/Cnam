package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Bsvisit;

public interface BsvistService {
	
	public boolean  saveBsvisit (Bsvisit vi)throws Exception;	
	public void  updateBsvisit (Bsvisit vi )throws Exception;
	public void deleteBsvisit (Bsvisit vi )throws Exception;
	public List <Bsvisit> findAllPers ()throws Exception; 
	public List <Bsvisit> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Bsvisit> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;


}
