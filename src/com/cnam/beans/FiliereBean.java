package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Filiere;
import com.cnam.services.FiliereService;
import com.cnam.services.imp.FiliereServiceImp;

@ManagedBean
@SessionScoped
public class FiliereBean {

	private Filiere filiere = new Filiere();
	@ManagedProperty(value = "#{filiereServ}")
	private FiliereService filiereService;

	private List<Filiere> listFiliere = new ArrayList<Filiere>();
	private boolean btnadd = true;
	private boolean btnedit = false;
	private boolean read;

	public void clickAdd() {
		filiere = new Filiere();
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
			filiereService.deleteFiliere(filiere);
			filiere = new Filiere();
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void modiferFiliere() {

		try {
			filiereService.updateFiliere(filiere);

			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
			filiere = new Filiere();
			btnadd = true;
			btnedit = false;

		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterFiliere() {

		try {
			boolean testEmail = filiereService.saveFiliere(filiere);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				filiere = new Filiere();
			} else {
				// facecontext teb3a el message mta3 el affichage fil Xhtm
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Filière Existante "));

			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur d'insertion"));
			e.printStackTrace();
		}

	}



	public List<Filiere> getListFiliere() {
		try {
			listFiliere = filiereService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listFiliere;
	}

	public void setListFiliere(List<Filiere> listFiliere) {
		this.listFiliere = listFiliere;
	}

	public void annuler() {

		filiere = new Filiere();
		btnadd = true;
		btnedit = false;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	

	public FiliereService getFiliereService() {
		return filiereService;
	}

	public void setFiliereService(FiliereService filiereService) {
		this.filiereService = filiereService;
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
