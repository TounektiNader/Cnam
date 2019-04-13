package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Centrecnam;
import com.cnam.services.CentrecnamService;
import com.cnam.services.imp.CentrecnamServiceImp;

@ManagedBean
@SessionScoped
public class CentrecnamBean {
	
	private Centrecnam centrecnam = new Centrecnam();
	@ManagedProperty (value="#{centrecnamServ}")
	private CentrecnamService centrecnamService ;
	
	private List<Centrecnam> listCentrecnam = new ArrayList<Centrecnam>();
	private boolean btnadd = true;
	private boolean btnedit = false;
	private boolean read;
	
	
	public void clickAdd() {
		centrecnam = new Centrecnam();
		read=false;
		btnadd = true;
		btnedit = false;
	}
	
	
	public void clickEdit() {
		btnadd = false;
		btnedit = true;
		read =true;

	}
	
	
	
	public void supprimer() {

		try {
			centrecnamService.deleteCentrecnam(centrecnam);
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			centrecnam = new Centrecnam();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}



	public void modiferCentrecnam() {

		try {
		 centrecnamService.updateCentrecnam(centrecnam);
		

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				centrecnam = new Centrecnam();
				btnadd = true;
				btnedit = false;
				} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterCentrecnam() {

		try {
			boolean testEmail = centrecnamService.saveCentrecnam(centrecnam);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				centrecnam = new Centrecnam();
			} else {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Centre Cnam  Existant "));

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




	public List<Centrecnam> getListCentrecnam() {
		try {
			listCentrecnam = centrecnamService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listCentrecnam;
	}

	public void setListCentrecnam(List<Centrecnam> listCentrecnam) {
		this.listCentrecnam = listCentrecnam;
	}

	public void annuler() {

		centrecnam = new Centrecnam();
		btnadd = true;
		btnedit = false;
	}

	public Centrecnam getCentrecnam() {
		return centrecnam;
	}

	public void setCentrecnam(Centrecnam centrecnam) {
		this.centrecnam = centrecnam;
	}


	public CentrecnamService getCentrecnamService() {
		return centrecnamService;
	}


	public void setCentrecnamService(CentrecnamService centrecnamService) {
		this.centrecnamService = centrecnamService;
	}


	public boolean isRead() {
		return read;
	}


	public void setRead(boolean read) {
		this.read = read;
	}


}
