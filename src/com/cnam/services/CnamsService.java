package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Cnams;

public interface CnamsService {
	public boolean  saveCnams (Cnams cn)throws Exception;	
	public void  updateCnams (Cnams cn )throws Exception;
	public void deleteCnams (Cnams cn )throws Exception;
	public List <Cnams> findAllPers ()throws Exception; 
	public List <Cnams> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Cnams> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;


}
