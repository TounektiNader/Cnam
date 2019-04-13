package com.cnam.beans;

import java.util.ArrayList;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;


import com.cnam.entity.Beneficiaire;

import com.cnam.services.BeneficiaireService;

import com.cnam.services.imp.BeneficiaireServiceImp;



@ManagedBean
@SessionScoped
public class BeneficiaireBean {
	

	private Beneficiaire beneficiaire = new Beneficiaire();
	@ManagedProperty (value="#{beneficiaireServ}")
	private BeneficiaireService beneficiaireService ;

	private List<Beneficiaire> listBeneficiaire = new ArrayList<Beneficiaire>();
	private boolean btnadd = true;
	private boolean read;
	private boolean btnedit = false;
	
	
	
	public void clickAdd() {
		beneficiaire = new Beneficiaire();
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
			beneficiaireService.deleteBeneficiaire(beneficiaire);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			beneficiaire = new Beneficiaire();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void modiferBeneficiaire() {

		try {
			 beneficiaireService.updateBeneficiaire(beneficiaire);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				beneficiaire = new Beneficiaire();
				btnadd = true;
				btnedit = false;
			
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterBenficiaire() {

		try {
			boolean testEmail = beneficiaireService.saveBeneficiaire(beneficiaire);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				beneficiaire = new Beneficiaire();
			} else {
				// facecontext teb3a el message mta3 el affichage fil Xhtml
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Béneficiaire  Existant "));

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

	
	

	public List<Beneficiaire> getListBeneficiaire() {
		try {
			listBeneficiaire = beneficiaireService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listBeneficiaire;
	}

	public void setListBeneficiaire(List<Beneficiaire> listBeneficiaire) {
		this.listBeneficiaire = listBeneficiaire;
	}

	public void annuler() {

		beneficiaire = new Beneficiaire();
		btnadd = true;
		btnedit = false;
	}

	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public BeneficiaireService getBeneficiaireService() {
		return beneficiaireService;
	}

	public void setBeneficiaireService(BeneficiaireService beneficiaireService) {
		this.beneficiaireService = beneficiaireService;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}
	


}
