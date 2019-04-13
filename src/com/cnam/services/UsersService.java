package com.cnam.services;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.cnam.entity.Users;

public interface UsersService {
	
	public boolean  saveUsers (Users us)throws Exception;	
	public void  updateUsers (Users us )throws Exception;
	public void deleteUsers (Users us )throws Exception;
	public List <Users> findAllPers ()throws Exception; 
	public List <Users> findPersByCritertia( Criterion cr)throws Exception;	
	public List <Users> findPersByCritertia( Criterion cr,Criterion cr2)throws Exception;


}
