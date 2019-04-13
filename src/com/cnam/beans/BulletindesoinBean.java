package com.cnam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cnam.entity.Bsvisit;
import com.cnam.entity.Bulletindesoin;
import com.cnam.services.BulletindesoinService;
import com.cnam.services.imp.BulletindesoinServiceImp;

@ManagedBean
@SessionScoped
public class BulletindesoinBean {
	

	private Bulletindesoin bulletindesoin = new Bulletindesoin();
	@ManagedProperty (value="#{bulletindesoinServ}")
	private BulletindesoinService bulletindesoinService ;
	
	private List<Bulletindesoin> listBulletindesoin = new ArrayList<Bulletindesoin>();
	private boolean btnadd = true;
	private boolean btnedit = false;
	 private boolean read;


		
		public void clickAdd() {
			bulletindesoin = new Bulletindesoin();
			read=false;
			btnadd = true;
			btnedit = false;
			
		}

	

	public void clickEdit() {
		btnadd = false;
		btnedit = true;
		read=true ; 

	}
	

	
	public void supprimer() {

		try {
			bulletindesoinService.deleteBulletindesoin(bulletindesoin);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			bulletindesoin = new Bulletindesoin();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	public void modiferBulletindesoin() {

		try {
			 bulletindesoinService.updateBulletindesoin(bulletindesoin);


				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
				bulletindesoin = new Bulletindesoin();
				btnadd = true;
				btnedit = false;
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public void ajouterBulletindesoin() {

		try {
			boolean testEmail = bulletindesoinService.saveBulletindesoin(bulletindesoin);
			if (testEmail) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Ajout avec succès"));
				bulletindesoin = new Bulletindesoin();
			} else {
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Bulletin De Soin  Existante "));

			}
		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur d'insertion"));
			e.printStackTrace();
		}

	}


	public BulletindesoinService getBulletindesoinService() {
		return bulletindesoinService;
	}



	public void setBulletindesoinService(BulletindesoinService bulletindesoinService) {
		this.bulletindesoinService = bulletindesoinService;
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


	// hethi wela bil constructeur bech ta3mel affichage fil page web
	// @PostConstruct
	// init(){
	//
	// }

	public List<Bulletindesoin> getListBulletindesoin() {
		try {
			listBulletindesoin = bulletindesoinService.findAllPers();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listBulletindesoin;
	}

	public void setListBulletindesoin(List<Bulletindesoin> listBulletindesoin) {
		this.listBulletindesoin = listBulletindesoin;
	}

	public void annuler() {

		bulletindesoin = new Bulletindesoin();
		btnadd = true;
		btnedit = false;
	}

	public Bulletindesoin getBulletindesoin() {
		return bulletindesoin;
	}

	public void setBulletindesoin(Bulletindesoin bulletindesoin) {
		this.bulletindesoin = bulletindesoin;
	}




}
