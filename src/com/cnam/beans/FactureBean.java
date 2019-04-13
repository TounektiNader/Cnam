package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Decision;
import com.cnam.entity.Facture;
import com.cnam.services.FactureService;
import com.cnam.services.imp.FactureServiceImp;

@ManagedBean
@SessionScoped
public class FactureBean {
	
	private Facture facture = new Facture();
	@ManagedProperty (value="#{factureServ}")
	private FactureService factureService ;
	
	private List<Facture> listFacture = new ArrayList<Facture>();
	private boolean btnadd = true;	
	private boolean btnedit = false;
	private boolean read;
	
	public void clickAdd() {
		facture = new Facture();
		read=false;
		btnadd = true;
		btnedit = false; 
		}

	


	public void clickEdit() {
		btnadd = false;
		btnedit = true;
		read = true;

	}
	
	public void supprimer() {

		try {
			factureService.deleteFacture(facture);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			facture = new Facture();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	

	

	public void modiferFacture() {

		try {
			 factureService.updateFacture(facture);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				facture = new Facture();
				btnadd = true;
				btnedit = false;
					} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterFacture() {

		try {
			boolean testEmail = factureService.saveFacture(facture);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				facture = new Facture();
			} else {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Facture Existante "));

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

	// hethi wela bil constructeur bech ta3mel affichage fil page web
	// @PostConstruct
	// init(){
	//
	// }

	public List<Facture> getListFacture() {
		try {
			listFacture = factureService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listFacture;
	}

	public void setListFacture(List<Facture> listFacture) {
		this.listFacture = listFacture;
	}

	public void annuler() {

		facture = new Facture();
		btnadd = true;
		btnedit = false;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}




	public FactureService getFactureService() {
		return factureService;
	}




	public void setFactureService(FactureService factureService) {
		this.factureService = factureService;
	}




	public boolean isRead() {
		return read;
	}




	public void setRead(boolean read) {
		this.read = read;
	}

	


}
