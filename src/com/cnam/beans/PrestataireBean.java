package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Plafons;
import com.cnam.entity.Prestataire;
import com.cnam.services.PrestataireService;
import com.cnam.services.imp.PrestataireServiceImp;

@ManagedBean
@SessionScoped
public class PrestataireBean {
	
	private Prestataire prestataire = new Prestataire();
	@ManagedProperty (value="#{prestataireServ}")
	private PrestataireService prestataireService ;
	
	private List<Prestataire> listPrestataire= new ArrayList<Prestataire>();
	private boolean btnadd = true;
	private boolean btnedit = false;
	private boolean read;
		
		public void clickAdd() {
			prestataire = new Prestataire();
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
			prestataireService.deletePrestataire(prestataire);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			prestataire = new Prestataire();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	
	

	public void modiferPrestataire() {

		try {
			 prestataireService.updatePrestataire(prestataire);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				prestataire = new Prestataire();
				btnadd = true;
				btnedit = false;
					} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterPrestataire() {

		try {
			boolean testEmail = prestataireService.savePrestataire(prestataire);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				prestataire = new Prestataire();
			} else {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Prestataire Existant "));

			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur d'insertion"));
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




	public List<Prestataire> getListPrestataire() {
		try {
			listPrestataire = prestataireService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listPrestataire;
	}

	public void setListPrestataire(List<Prestataire> listPrestataire) {
		this.listPrestataire = listPrestataire;
	}

	public void annuler() {

		prestataire = new Prestataire();
		btnadd = true;
		btnedit = false;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}



	public PrestataireService getPrestataireService() {
		return prestataireService;
	}



	public void setPrestataireService(PrestataireService prestataireService) {
		this.prestataireService = prestataireService;
	}



	public boolean isRead() {
		return read;
	}



	public void setRead(boolean read) {
		this.read = read;
	}




}
