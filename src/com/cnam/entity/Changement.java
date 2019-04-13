package com.cnam.entity;
// Generated 20 avr. 2017 00:49:55 by Hibernate Tools 5.2.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Changement generated by hbm2java
 */
@Entity
@Table(name = "changement", catalog = "app_cnam")
public class Changement implements java.io.Serializable {

	private Integer idChangement;
	private int matricule;
	private String user;
	private String dateChangement;
	private String filiereActuelle;
	private String filiereChange;
	private String etat;

	public Changement() {
	}

	public Changement(int matricule, String user, String dateChangement, String filiereActuelle, String filiereChange,
			String etat) {
		this.matricule = matricule;
		this.user = user;
		this.dateChangement = dateChangement;
		this.filiereActuelle = filiereActuelle;
		this.filiereChange = filiereChange;
		this.etat = etat;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idChangement", unique = true, nullable = false)
	public Integer getIdChangement() {
		return this.idChangement;
	}

	public void setIdChangement(Integer idChangement) {
		this.idChangement = idChangement;
	}

	@Column(name = "matricule", nullable = false)
	public int getMatricule() {
		return this.matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	@Column(name = "user", nullable = false, length = 200)
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "DateChangement", nullable = false, length = 200)
	public String getDateChangement() {
		return this.dateChangement;
	}

	public void setDateChangement(String dateChangement) {
		this.dateChangement = dateChangement;
	}

	@Column(name = "filiereActuelle", nullable = false, length = 200)
	public String getFiliereActuelle() {
		return this.filiereActuelle;
	}

	public void setFiliereActuelle(String filiereActuelle) {
		this.filiereActuelle = filiereActuelle;
	}

	@Column(name = "filiereChange", nullable = false, length = 200)
	public String getFiliereChange() {
		return this.filiereChange;
	}

	public void setFiliereChange(String filiereChange) {
		this.filiereChange = filiereChange;
	}

	@Column(name = "etat", nullable = false, length = 200)
	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}
