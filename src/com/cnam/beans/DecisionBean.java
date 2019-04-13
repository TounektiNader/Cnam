package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Beneficiaire;
import com.cnam.entity.Decision;
import com.cnam.services.DecisionService;
import com.cnam.services.imp.DecisionServiceImp;

@ManagedBean
@SessionScoped
public class DecisionBean {
	private Decision decision = new Decision();
	@ManagedProperty (value="#{decisionServ}")
	private DecisionService decisionService ;
	
	private List<Decision> listDecision = new ArrayList<Decision>();
	private boolean btnadd = true;
	private boolean btnedit = false;
	private boolean read;
	
	public void clickAdd() {
		decision = new Decision();
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
			decisionService.deleteDecision(decision);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			decision = new Decision();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	public void modiferDecision() {

		try {
			 decisionService.updateDecision(decision);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				decision = new Decision();
				btnadd = true;
				btnedit = false;
					} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterDecision() {

		try {
			boolean testEmail = decisionService.saveDecision(decision);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				decision = new Decision();
			} else {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Décision Existante "));

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

	public List<Decision> getListDecision() {
		try {
			listDecision = decisionService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listDecision;
	}

	public void setListDecision(List<Decision> listDecision) {
		this.listDecision = listDecision;
	}

	public void annuler() {

		decision = new Decision();
		btnadd = true;
		btnedit = false;
	}

	public Decision getDecision() {
		return decision;
	}

	public void setDecision(Decision decision) {
		this.decision = decision;
	}



	public DecisionService getDecisionService() {
		return decisionService;
	}



	public void setDecisionService(DecisionService decisionService) {
		this.decisionService = decisionService;
	}



	public boolean isRead() {
		return read;
	}



	public void setRead(boolean read) {
		this.read = read;
	}




}
