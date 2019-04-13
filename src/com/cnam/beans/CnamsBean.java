package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Cnams;
import com.cnam.entity.Convention;
import com.cnam.services.CnamsService;
import com.cnam.services.imp.CnamsServiceImp;

@ManagedBean
@SessionScoped
public class CnamsBean {
	private Cnams cnams = new Cnams();
	@ManagedProperty (value="#{cnamsServ}")
	private CnamsService cnamsService ;
	
	private List<Cnams> listCnams = new ArrayList<Cnams>();
	private boolean btnadd = true;
	private boolean read;
	private boolean btnedit = false;
	
	public void clickAdd() {
		cnams = new Cnams();
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
			cnamsService.deleteCnams(cnams);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			cnams = new Cnams();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	

	public void modiferCnams() {

		try {
			cnamsService.updateCnams(cnams);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				cnams = new Cnams();
				btnadd = true;
				btnedit = false;
			
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterCnams() {

		try {
			boolean testEmail = cnamsService.saveCnams(cnams);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				cnams = new Cnams();
			} else {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Cnam  Existante "));

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

	

	public List<Cnams> getListCnams() {
		try {
			listCnams = cnamsService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listCnams;
	}

	public void setListCnams(List<Cnams> listCnams) {
		this.listCnams = listCnams;
	}

	public void annuler() {

		cnams = new Cnams();
		btnadd = true;
		btnedit = false;
	}

	public Cnams getCnams() {
		return cnams;
	}

	public void setCnams(Cnams cnams) {
		this.cnams = cnams;
	}


	public boolean isRead() {
		return read;
	}


	public void setRead(boolean read) {
		this.read = read;
	}


	public CnamsService getCnamsService() {
		return cnamsService;
	}


	public void setCnamsService(CnamsService cnamsService) {
		this.cnamsService = cnamsService;
	}




}
