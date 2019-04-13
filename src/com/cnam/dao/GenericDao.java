package com.cnam.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericDao  {
	
	public void save (Object entity)throws Exception;
	public void delete (Object entity)throws Exception;
	public List findAll (Class cls)throws Exception; 
	public List findByCritertia(Class cls , Criterion cr)throws Exception;	
	public List findByCritertia(Class cls , Criterion cr,Criterion cr2)throws Exception;	

}

