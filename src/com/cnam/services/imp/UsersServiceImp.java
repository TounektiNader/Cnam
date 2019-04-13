package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.UsersDao;
import com.cnam.entity.Users;
import com.cnam.services.UsersService;

public class UsersServiceImp implements UsersService {
	
private UsersDao  usersDao  ; 
	
	@Override
	public boolean saveUsers (Users us) throws Exception {

		Criterion cr = Restrictions.eq("username", us.getUsername());
		boolean var = false;
		int name = findPersByCritertia(cr).size();
		

		if (name== 0) {
			usersDao.save(us);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateUsers(Users us) throws Exception {
		
			usersDao.save(us);
		
	}

	@Override
	public void deleteUsers(Users us) throws Exception {
		usersDao.delete(us);
	}

	@Override
	public List<Users> findAllPers() throws Exception {

		return usersDao.findAll(Users.class);
	}

	@Override
	public List<Users> findPersByCritertia(Criterion cr) throws Exception {

		return usersDao.findByCritertia(Users.class, cr);
	}

	@Override
	public List<Users> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return usersDao.findByCritertia(Users.class, cr, cr2);
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}


}
