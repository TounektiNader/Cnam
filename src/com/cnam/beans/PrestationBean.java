package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Prestataire;
import com.cnam.entity.Prestation;
import com.cnam.services.PrestationService;
import com.cnam.services.imp.PrestationServiceImp;

@ManagedBean
@SessionScoped
public class PrestationBean {
	
	private Prestation prestation = new Prestation();
	@ManagedProperty (value="#{prestationServ}")
	private PrestationService prestationService ;
	
	private List<Prestation> listPrestation= new ArrayList<Prestation>();
	private boolean btnadd = true;
	private boolean btnedit = false;
	private boolean read;
	
	public void clickAdd() {
		prestation = new Prestation();
		read=false;
		btnadd = true;
		btnedit = false; 
		}

	


	public void clickEdit() {
		btnadd = false;
		btnedit = true;

	}

	
	public void supprimer() {

		try {
			prestationService.deletePrestation(prestation);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			prestation = new Prestation();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	


	public void modiferPrestation() {

		try {
			 prestationService.updatePrestation(prestation);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				prestation = new Prestation();
				btnadd = true;
				btnedit = false;
			
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,   new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterPrestation() {

		try {
			boolean testEmail = prestationService.savePrestation(prestation);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				prestation = new Prestation();
			} else {
			
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Prestation Existante "));

			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur d'insertion"));
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

	


	public List<Prestation> getListPrestation() {
		try {
			listPrestation = prestationService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listPrestation;
	}

	public void setListPrestation(List<Prestation> listPrestation) {
		this.listPrestation = listPrestation;
	}

	public void annuler() {

		prestation = new Prestation();
		btnadd = true;
		btnedit = false;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}




	public PrestationService getPrestationService() {
		return prestationService;
	}




	public void setPrestationService(PrestationService prestationService) {
		this.prestationService = prestationService;
	}




	public boolean isRead() {
		return read;
	}




	public void setRead(boolean read) {
		this.read = read;
	}






}
