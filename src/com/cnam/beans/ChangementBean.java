package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Centrecnam;
import com.cnam.entity.Changement;
import com.cnam.services.ChangementService;
import com.cnam.services.imp.ChangementServiceImp;

@ManagedBean
@SessionScoped
public class ChangementBean {
	
	private Changement changement = new Changement();
	@ManagedProperty (value="#{changementServ}")
	private ChangementService changementService ;
	
	private List<Changement> listChangement = new ArrayList<Changement>();
	private boolean btnadd = true;
	private boolean btnedit = false;	
	private boolean read;
	
	public void clickAdd() {
		changement = new Changement();
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
			changementService.deleteChangement(changement);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			changement = new Changement();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	

	public void modiferChangement() {

		try {
			 changementService.updateChangement(changement);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				changement = new Changement();
				btnadd = true;
				btnedit = false;
			
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterChangement() {

		try {
			boolean testEmail = changementService.saveChangement(changement);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				changement = new Changement();
			} else {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Demande Changement Existant "));

			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur d'insertion"));
			e.printStackTrace();
		}

	}

	public ChangementService getChangementService() {
		return changementService;
	}


	public void setChangementService(ChangementService changementService) {
		this.changementService = changementService;
	}


	public boolean isRead() {
		return read;
	}


	public void setRead(boolean read) {
		this.read = read;
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



	

	public List<Changement> getListChangement() {
		try {
			listChangement = changementService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listChangement;
	}

	public void setListChangement(List<Changement> listChangement) {
		this.listChangement = listChangement;
	}

	public void annuler() {

		changement = new Changement();
		btnadd = true;
		btnedit = false;
	}

	public Changement getChangement() {
		return changement;
	}

	public void setChangement(Changement changement) {
		this.changement = changement;
	}




}
