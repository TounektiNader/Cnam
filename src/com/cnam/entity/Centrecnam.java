package com.cnam.entity;
// Generated 20 avr. 2017 00:49:55 by Hibernate Tools 5.2.0.Beta1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Centrecnam generated by hbm2java
 */
@Entity
@Table(name = "centrecnam", catalog = "app_cnam")
public class Centrecnam implements java.io.Serializable {

	private int codeCnam;
	private String libelle;
	private Set<Bulletindesoin> bulletindesoins = new HashSet<Bulletindesoin>(0);
	private Set<Priseencharge> priseencharges = new HashSet<Priseencharge>(0);
	private Set<Users> userses = new HashSet<Users>(0);

	public Centrecnam() {
	}

	public Centrecnam(int codeCnam, String libelle) {
		this.codeCnam = codeCnam;
		this.libelle = libelle;
	}

	public Centrecnam(int codeCnam, String libelle, Set<Bulletindesoin> bulletindesoins,
			Set<Priseencharge> priseencharges, Set<Users> userses) {
		this.codeCnam = codeCnam;
		this.libelle = libelle;
		this.bulletindesoins = bulletindesoins;
		this.priseencharges = priseencharges;
		this.userses = userses;
	}

	@Id

	@Column(name = "CodeCnam", unique = true, nullable = false)
	public int getCodeCnam() {
		return this.codeCnam;
	}

	public void setCodeCnam(int codeCnam) {
		this.codeCnam = codeCnam;
	}

	@Column(name = "libelle", nullable = false, length = 300)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "centrecnam")
	public Set<Bulletindesoin> getBulletindesoins() {
		return this.bulletindesoins;
	}

	public void setBulletindesoins(Set<Bulletindesoin> bulletindesoins) {
		this.bulletindesoins = bulletindesoins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "centrecnam")
	public Set<Priseencharge> getPriseencharges() {
		return this.priseencharges;
	}

	public void setPriseencharges(Set<Priseencharge> priseencharges) {
		this.priseencharges = priseencharges;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "centrecnam")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}
