package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Bulletindesoin;

public interface BulletindesoinService {
	public boolean  saveBulletindesoin (Bulletindesoin bs)throws Exception;	
	public void  updateBulletindesoin (Bulletindesoin bs )throws Exception;
	public void deleteBulletindesoin (Bulletindesoin bs )throws Exception;
	public List <Bulletindesoin> findAllPers ()throws Exception; 
	public List <Bulletindesoin> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Bulletindesoin> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;


}
