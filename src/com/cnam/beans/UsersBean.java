package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Prestation;
import com.cnam.entity.Users;
import com.cnam.services.UsersService;
import com.cnam.services.imp.UsersServiceImp;

@ManagedBean
@SessionScoped

public class UsersBean {
	private Users users = new Users();
	@ManagedProperty (value="#{usersServ}")
	private UsersService usersService ;
	
	private List<Users> listUsers= new ArrayList<Users>();
	private boolean btnadd = true;
	private boolean btnedit = false;	
    private boolean read;
	
	public void clickAdd() {
		users = new Users() ;
		read=false;
		btnadd = true;
		btnedit = false; 
		}
	
	

	public void clickEdit() {
		btnadd = false;
		btnedit = true;
		read= true ; 

	}
	public void supprimer() {

		try {
			usersService.deleteUsers(users);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			users = new Users();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	
	

	public void modiferUsers() {

		try {
			 usersService.updateUsers(users);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				users = new Users();
				btnadd = true;
				btnedit = false;
					} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterUsers() {

		try {
			boolean testEmail = usersService.saveUsers(users);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				users = new Users();
			} else {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "User Existant "));

			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur d'insertion"));
			e.printStackTrace();
		}

	}

	public boolean isBtnadd() {
		return btnadd;
	}

	public void setBtnadd(boolean btnadd) {
		this.btnadd = btnadd;
	}

	public boolean isBtnedit() {
		return btnedit;
	}

	public void setBtnedit(boolean btnedit) {
		this.btnedit = btnedit;
	}

	

	public List<Users> getListUsers() {
		try {
			listUsers = usersService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listUsers;
	}

	public void setListUsers(List<Users> listUsers) {
		this.listUsers = listUsers;
	}

	public void annuler() {

		users = new Users();
		btnadd = true;
		btnedit = false;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}



	public UsersService getUsersService() {
		return usersService;
	}



	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}



	public boolean isRead() {
		return read;
	}



	public void setRead(boolean read) {
		this.read = read;
	}




}
