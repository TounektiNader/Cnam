package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Bsmedicament;

public interface BsmedicamentService {
	public boolean  saveBsmedicament (Bsmedicament med)throws Exception;	
	public void  updateBsmedicament (Bsmedicament med )throws Exception;
	public void deleteBsmedicament (Bsmedicament med )throws Exception;
	public List <Bsmedicament> findAllPers ()throws Exception; 
	public List <Bsmedicament> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Bsmedicament> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;

}
