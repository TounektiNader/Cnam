package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Bsacte;

public interface BsacteService {
	public boolean  savebsacte (Bsacte ac)throws Exception;	
	public void  updatebsacte (Bsacte ac )throws Exception;
	public void deletebsacte (Bsacte ac )throws Exception;
	public List <Bsacte> findAllPers ()throws Exception; 
	public List <Bsacte> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Bsacte> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;

}
