package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Convention;
import com.cnam.entity.Filiere;
import com.cnam.services.ConvetionService;
import com.cnam.services.imp.ConvetionServiceImp;

@ManagedBean
@SessionScoped
public class ConvetionBean {
	
	private Convention convention = new Convention();
	@ManagedProperty (value="#{conventionServ}")
	private ConvetionService conventionService ;
	
	private List<Convention> listConvention = new ArrayList<Convention>();
	private boolean btnadd = true;
	private boolean btnedit = false;	
	private boolean read;

	

	public void clickAdd() {
		convention = new Convention();
		read=false;
		btnadd = true;
		btnedit = false;
	}
	
	public void clickEdit() {
		btnadd = false;
		btnedit = true;
		read=true;

	}
	
	public void supprimer() {

		try {
			conventionService.deleteConvention(convention);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			convention = new Convention();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	


	public void modiferConvention() {

		try {
		 conventionService.updateConvention(convention);
		

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				convention = new Convention();
				btnadd = true;
				btnedit = false;
			
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterConvention() {

		try {
			boolean testEmail = conventionService.saveConvention(convention);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				convention = new Convention();
			} else {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Convention Existante "));

			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur d'insertion"));
			e.printStackTrace();
		}

	}


	public List<Convention> getListConvention() {
		try {
			listConvention = conventionService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listConvention;
	}

	public void setListConvention(List<Convention> listConvention) {
		this.listConvention = listConvention;
	}

	public void annuler() {

		convention = new Convention();
		btnadd = true;
		btnedit = false;
	}

	public Convention getConvention() {
		return convention;
	}

	public void setConvention(Convention convention) {
		this.convention = convention;
	}

	
	

	public ConvetionService getConventionService() {
		return conventionService;
	}

	public void setConventionService(ConvetionService conventionService) {
		this.conventionService = conventionService;
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

	
	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}



}
