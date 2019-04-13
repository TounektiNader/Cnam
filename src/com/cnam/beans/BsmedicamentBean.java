package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Beneficiaire;
import com.cnam.entity.Bsmedicament;
import com.cnam.services.BsmedicamentService;
import com.cnam.services.imp.BsmedicamentServiceImp;

@ManagedBean
@SessionScoped
public class BsmedicamentBean {
	
	private Bsmedicament bsmedicament = new Bsmedicament();
	@ManagedProperty (value="#{bsmedicamentServ}")
	private BsmedicamentService bsmedicamentService ;
	
	private List<Bsmedicament> listBsmedicament = new ArrayList<Bsmedicament>();
	private boolean btnadd = true;
	private boolean btnedit = false;
	private boolean read;
	
	public void clickAdd() {
		bsmedicament = new Bsmedicament();
		read=false;
		btnadd = true;
		btnedit = false;
		
	}

	public void clickEdit() {
		btnadd = false;
		btnedit = true;
		read= true;

	}
	


	public void supprimer() {

		try {
			bsmedicamentService.deleteBsmedicament(bsmedicament);
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			bsmedicament = new Bsmedicament();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	


	public void modiferBsmedicament() {

		try {
		 bsmedicamentService.updateBsmedicament(bsmedicament);
		

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				bsmedicament = new Bsmedicament();
				btnadd = true;
				btnedit = false;
				} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterBsmedicament() {

		try {
			boolean testEmail = bsmedicamentService.saveBsmedicament(bsmedicament);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				bsmedicament = new Bsmedicament();
			} else {
				// facecontext teb3a el message mta3 el affichage fil Xhtm
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Bulletin De Soin Médicament  Existante "));

			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur d'insertion"));
			e.printStackTrace();
		}

	}


	public BsmedicamentService getBsmedicamentService() {
		return bsmedicamentService;
	}

	public void setBsmedicamentService(BsmedicamentService bsmedicamentService) {
		this.bsmedicamentService = bsmedicamentService;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
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

	


	public List<Bsmedicament> getListBsmedicament() {
		try {
			listBsmedicament = bsmedicamentService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listBsmedicament;
	}

	public void setListBsmedicament(List<Bsmedicament> listBsmedicament) {
		this.listBsmedicament = listBsmedicament;
	}

	public void annuler() {

		bsmedicament = new Bsmedicament();
		btnadd = true;
		btnedit = false;
	}

	public Bsmedicament getBsmedicament() {
		return bsmedicament;
	}

	public void setBsmedicament(Bsmedicament bsmedicament) {
		this.bsmedicament = bsmedicament;
	}



}
