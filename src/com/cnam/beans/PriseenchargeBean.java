package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Prestation;
import com.cnam.entity.Priseencharge;
import com.cnam.services.PriseenchargeService;
import com.cnam.services.imp.PriseenchargeServiceImp;

@ManagedBean
@SessionScoped
public class PriseenchargeBean {

	private Priseencharge priseencharge = new Priseencharge();
	@ManagedProperty (value="#{priseenchargeServ}")
	private PriseenchargeService priseenchargeService ;
	
	private List<Priseencharge> listPriseencharge= new ArrayList<Priseencharge>();
	private boolean btnadd = true;
	private boolean btnedit = false;
    private boolean read;
	
	public void clickAdd() {
		priseencharge = new Priseencharge();
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
			priseenchargeService.deletePriseencharge(priseencharge);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			priseencharge = new Priseencharge();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	

	public void modiferPriseencharge() {

		try {
			 priseenchargeService.updatePriseencharge(priseencharge);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				priseencharge = new Priseencharge();
				btnadd = true;
				btnedit = false;
					} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,   new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterPriseencharge() {

		try {
			boolean testEmail = priseenchargeService.savePriseencharge(priseencharge);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				priseencharge = new Priseencharge();
			} else {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Prise En Charge Existante "));

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

	



	public List<Priseencharge> getListPriseencharge() {
		try {
			listPriseencharge = priseenchargeService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listPriseencharge;
	}

	public void setListPriseencharge(List<Priseencharge> listPriseencharge) {
		this.listPriseencharge = listPriseencharge;
	}

	public void annuler() {

		priseencharge = new Priseencharge();
		btnadd = true;
		btnedit = false;
	}

	public Priseencharge getPriseencharge() {
		return priseencharge;
	}

	public void setPriseencharge(Priseencharge priseencharge) {
		this.priseencharge = priseencharge;
	}



	public PriseenchargeService getPriseenchargeService() {
		return priseenchargeService;
	}



	public void setPriseenchargeService(PriseenchargeService priseenchargeService) {
		this.priseenchargeService = priseenchargeService;
	}



	public boolean isRead() {
		return read;
	}



	public void setRead(boolean read) {
		this.read = read;
	}



}
