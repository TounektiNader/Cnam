package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Assuresociale;
import com.cnam.services.AssureService;
import com.cnam.services.imp.AssureServiceImp;


@ManagedBean
@SessionScoped
public class AssureBean {
	private Assuresociale assure = new Assuresociale();
	@ManagedProperty (value="#{assureServ}")
	private AssureService assureService ;
	
	private List<Assuresociale> listAssure = new ArrayList<Assuresociale>();
	private boolean btnadd = true;
	private boolean btnedit = false;
	private boolean read;

	
	public void clickAdd() {
		assure = new Assuresociale();
		read=false;
		btnadd = true;
		btnedit = false;
	}
	


	public void clickEdit() {
		btnadd = false;
		btnedit = true;
		read=true ; 

	}

	public void supprimer() {

		try {
			assureService.deleteAssure(assure);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));

			assure = new Assuresociale();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	


	public void modiferAssure() {

		try {
			 assureService.updateAssure(assure);
			 
			    FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				assure = new Assuresociale();
				btnadd = true;
				btnedit = false;
					} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterAssure() {

		try {
			boolean testEmail = assureService.saveAssure(assure);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				assure = new Assuresociale();
			} else {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Assurée Sociale Existant "));

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

	
	
	public List<Assuresociale> getListAssure() {
		try {
			listAssure = assureService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listAssure;
	}

	public void setListAssure(List<Assuresociale> listAssure) {
		this.listAssure = listAssure;
	}

	public void annuler() {

		assure = new Assuresociale();
		btnadd = true;
		btnedit = false;
	}

	public Assuresociale getAssure() {
		return assure;
	}

	public void setAssure(Assuresociale assure) {
		this.assure = assure;
	}









	public AssureService getAssureService() {
		return assureService;
	}



	public void setAssureService(AssureService assureService) {
		this.assureService = assureService;
	}



	public boolean isRead() {
		return read;
	}



	public void setRead(boolean read) {
		this.read = read;
	}




}
