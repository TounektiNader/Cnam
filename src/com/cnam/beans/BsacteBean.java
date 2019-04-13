package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Beneficiaire;
import com.cnam.entity.Bsacte;

import com.cnam.services.BsacteService;
import com.cnam.services.imp.BsacteServiceImp;




@ManagedBean
@SessionScoped
public class BsacteBean {
	
	private Bsacte bsacte = new Bsacte();
	@ManagedProperty (value="#{bsacteServ}")
	private BsacteService bsacteService ;
	
	private List<Bsacte> listBsacte = new ArrayList<Bsacte>();
	private boolean btnadd = true;
	private boolean btnedit = false;
	private boolean read;
	
	public void clickAdd() {
		bsacte = new Bsacte();
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
			bsacteService.deletebsacte(bsacte);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			bsacte = new Bsacte();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	

	public void modiferBsacte() {

		try {
			 bsacteService.updatebsacte(bsacte);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				bsacte = new Bsacte();
				btnadd = true;
				btnedit = false;
				
					} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterBsacte() {

		try {
			boolean testEmail = bsacteService.savebsacte(bsacte);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				bsacte = new Bsacte();
			} else {
		
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Bulletin De Soin Acte  Existant "));

			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur d'insertion"));
			e.printStackTrace();
		}

	}


	public BsacteService getBsacteService() {
		return bsacteService;
	}



	public void setBsacteService(BsacteService bsacteService) {
		this.bsacteService = bsacteService;
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



	public List<Bsacte> getListBsacte() {
		try {
			listBsacte = bsacteService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listBsacte;
	}

	public void setListBsacte(List<Bsacte> listBsacte) {
		this.listBsacte = listBsacte;
	}

	public void annuler() {

		bsacte = new Bsacte();
		btnadd = true;
		btnedit = false;
	}

	public Bsacte getBsacte() {
		return bsacte;
	}

	public void setBsacte(Bsacte bsacte) {
		this.bsacte = bsacte;
	}


}
