package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import com.cnam.entity.Utilisateur;
import com.cnam.services.UtilisateurService;
import com.cnam.services.imp.UtilisateurServiceImp;

@ManagedBean
@SessionScoped

public class UtilisateurBean {
	

	private Utilisateur utilisateur = new Utilisateur();
	@ManagedProperty (value="#{utilisateurServ}")
	private UtilisateurService utilisateurService ;
	
	private List<Utilisateur> listUtilisateur= new ArrayList<Utilisateur>();
	
	private boolean btnadd = true;
	private boolean btnedit = false;
	private boolean read;
	

	
	public void clickAdd() {
		utilisateur = new Utilisateur();
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
			utilisateurService.deleteUtilisateur(utilisateur);
			utilisateur = new Utilisateur();
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void modiferUtilisateur() {

		try {
			 utilisateurService.updateUtilisateur(utilisateur);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modification effectué succès"));
				utilisateur = new Utilisateur();
				btnadd = true;
				btnedit = false;
			
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}
	
	public void ajouterUtilisateur() {

		try {
			boolean testEmail = utilisateurService.saveUtilisateur(utilisateur);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				utilisateur = new Utilisateur();
			} else {
				// facecontext teb3a el message mta3 el affichage fil Xhtm
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Utilisateur Existant "));

			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur d'insertion"));
			e.printStackTrace();
		}

	}
	
	public List<Utilisateur> getListUtilisateur() {
		try {
			listUtilisateur= utilisateurService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listUtilisateur;
	}

	public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
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

	


	
	


	public void annuler() {

		utilisateur = new Utilisateur();
		btnadd = true;
		btnedit = false;
	}


	
	public UtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	
	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

}
