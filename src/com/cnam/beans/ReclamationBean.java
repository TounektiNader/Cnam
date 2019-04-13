package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

import com.cnam.entity.Bsacte;
import com.cnam.entity.Reclamation;
import com.cnam.services.ReclamationService;
import com.cnam.services.imp.ReclamationServiceImp;
import com.cnam.utils.SendEmail;


@ManagedBean
@SessionScoped

public class ReclamationBean {
	
	private Reclamation reclamation = new Reclamation();
	@ManagedProperty (value="#{reclamationServ}")
	private ReclamationService reclamationService ;
	
	private List<Reclamation> listReclamation= new ArrayList<Reclamation>();
	private boolean btnadd = true;
	private boolean btnedit = false;
	private boolean read =true ;
	String sub ;
	String obj;
	String recc;
	
	public void clickAdd() {
		reclamation = new Reclamation();
		read=false;
		btnadd = true;
		btnedit = false;
		
	}
	
	public void clickEdit() {
		btnadd = false;
		btnedit = true;
		read=true;

	}



	public ReclamationService getReclamationService() {
		return reclamationService;
	}

	public void setReclamationService(ReclamationService reclamationService) {
		this.reclamationService = reclamationService;
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

	public void modiferReclamation() {

		try {
			boolean testEmail = reclamationService.updateReclamation(reclamation);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage("Modification avec succès "));
				reclamation = new Reclamation();
				btnadd = true;
				btnedit = false;
			} else {
				// facecontext teb3a el message mta3 el affichage fil Xhtm
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage("Email existant "));

			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Erreur d'insertion "));
			e.printStackTrace();
		}

	}

	public void ajouterReclamation() {

		try {
			boolean testEmail = reclamationService.saveReclamation(reclamation);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage("Ajout avec succès "));
				reclamation = new Reclamation();
			} else {
				// facecontext teb3a el message mta3 el affichage fil Xhtm
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage("Email existant "));

			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Erreur d'insertion "));
			e.printStackTrace();
		}

	}



	public List<Reclamation> getListReclamation() {
		try {
			listReclamation = reclamationService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listReclamation;
	}

	public void setListReclamation(List<Reclamation> listReclamation) {
		this.listReclamation = listReclamation;
	}

	public void annuler() {

		reclamation = new Reclamation();
		btnadd = true;
		btnedit = false;
	}

	public Reclamation getReclamation() {
		return reclamation;
	}

	public void setReclamation(Reclamation reclamation) {
		this.reclamation = reclamation;
	}

	public void supprimer() {

		try {
			reclamationService.deleteReclamation(reclamation);
			reclamation = new Reclamation();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	
	public void envoyer() {

		try {
			SendEmail.envoyerEmail(reclamation.getEmail(), sub, obj);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public String getRecc() {
		return recc;
	}

	public void setRecc(String recc) {
		this.recc = recc;
	}

}
