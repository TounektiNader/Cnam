package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Facture;
import com.cnam.entity.Plafons;
import com.cnam.services.PlafonsService;
import com.cnam.services.imp.PlafonsServiceImp;


@ManagedBean
@SessionScoped

public class PlafonsBean {
	private Plafons plafons = new Plafons();
	@ManagedProperty (value="#{plafonsServ}")
	private PlafonsService plafonsService ;
	
	private List<Plafons> listPlafons = new ArrayList<Plafons>();
	private boolean btnadd = true;
	private boolean btnedit = false;
    private boolean read;
	
	public void clickAdd() {
		plafons = new Plafons();
		read=false;
		btnadd = true;
		btnedit = false; 
		}
	


	public void clickEdit() {
		btnadd = false;
		btnedit = true;
		read = true ;

	}
	
	public void supprimer() {

		try {
			plafonsService.deletePlafons(plafons);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			plafons = new Plafons();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	


	public void modiferFiliere() {

		try {
			 plafonsService.updatePlafons(plafons);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				plafons = new Plafons();
				btnadd = true;
				btnedit = false;
			
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterPlafons() {

		try {
			boolean testEmail = plafonsService.savePlafons(plafons);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				plafons = new Plafons();
			} else {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Plafond Existant "));

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




	public List<Plafons> getListPlafons() {
		try {
			listPlafons = plafonsService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listPlafons;
	}

	public void setListPlafons(List<Plafons> listPlafons) {
		this.listPlafons = listPlafons;
	}

	public void annuler() {

		plafons = new Plafons();
		btnadd = true;
		btnedit = false;
	}

	public Plafons getPlafons() {
		return plafons;
	}

	public void setPlafons(Plafons plafons) {
		this.plafons = plafons;
	}



	public PlafonsService getPlafonsService() {
		return plafonsService;
	}



	public void setPlafonsService(PlafonsService plafonsService) {
		this.plafonsService = plafonsService;
	}



	public boolean isRead() {
		return read;
	}



	public void setRead(boolean read) {
		this.read = read;
	}






}
