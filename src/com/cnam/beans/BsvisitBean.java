package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Bsmedicament;
import com.cnam.entity.Bsvisit;
import com.cnam.services.BsvistService;
import com.cnam.services.imp.BsvisitServiceImp;

@ManagedBean
@SessionScoped
public class BsvisitBean {
	
	private Bsvisit bsvisit = new Bsvisit();
	@ManagedProperty (value="#{bsvisitServ}")
	private BsvistService bsvistService ;
	
	private List<Bsvisit> listBsvist = new ArrayList<Bsvisit>();
	private boolean btnadd = true;
	private boolean btnedit = false;
    private boolean read;


	
	public void clickAdd() {
		bsvisit = new Bsvisit();
		read=false;
		btnadd = true;
		btnedit = false;
		
	}

	
	public void supprimer() {

		try {
			bsvistService.deleteBsvisit(bsvisit);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			bsvisit = new Bsvisit();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	


	public void clickEdit() {
		btnadd = false;
		btnedit = true;

	}
	


	public void modiferBsvisit() {

		try {
			 bsvistService.updateBsvisit(bsvisit);
			

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				bsvisit = new Bsvisit();
				btnadd = true;
				btnedit = false;
					} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterBsvisit() {

		try {
			boolean testEmail = bsvistService.saveBsvisit(bsvisit);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				bsvisit = new Bsvisit();
			} else {
				// facecontext teb3a el message mta3 el affichage fil Xhtm
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Bulletin De Soin Visit  Existante "));

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

	
	

	public List<Bsvisit> getListBsvist() {
		try {
			listBsvist = bsvistService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return listBsvist;
	}


	public void setListBsvist(List<Bsvisit> listBsvist) {
		this.listBsvist = listBsvist;
	}


	
	
	public void annuler() {

		bsvisit = new Bsvisit();
		btnadd = true;
		btnedit = false;
	}

	public Bsvisit getBsvisit() {
		return bsvisit;
	}

	public void setBsvisit(Bsvisit bsvisit) {
		this.bsvisit = bsvisit;
	}


	public BsvistService getBsvistService() {
		return bsvistService;
	}


	public void setBsvistService(BsvistService bsvistService) {
		this.bsvistService = bsvistService;
	}


	public boolean isRead() {
		return read;
	}


	public void setRead(boolean read) {
		this.read = read;
	}




}
