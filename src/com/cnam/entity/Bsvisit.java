package com.cnam.entity;
// Generated 20 avr. 2017 00:49:55 by Hibernate Tools 5.2.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Bsvisit generated by hbm2java
 */
@Entity
@Table(name = "bsvisit", catalog = "app_cnam")
public class Bsvisit implements java.io.Serializable {

	private int codVisit;
	private Bulletindesoin bulletindesoin;
	private double montantDepanseVisit;
	private int annee;

	public Bsvisit() {
		bulletindesoin = new Bulletindesoin();
		
	}

	public Bsvisit(int codVisit, Bulletindesoin bulletindesoin, double montantDepanseVisit, int annee) {
		this.codVisit = codVisit;
		this.bulletindesoin = bulletindesoin;
		this.montantDepanseVisit = montantDepanseVisit;
		this.annee = annee;
	}

	@Id

	@Column(name = "codVisit", unique = true, nullable = false)
	public int getCodVisit() {
		return this.codVisit;
	}

	public void setCodVisit(int codVisit) {
		this.codVisit = codVisit;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codBdeSoin", nullable = false)
	public Bulletindesoin getBulletindesoin() {
		return this.bulletindesoin;
	}

	public void setBulletindesoin(Bulletindesoin bulletindesoin) {
		this.bulletindesoin = bulletindesoin;
	}

	@Column(name = "montantDepanseVisit", nullable = false, precision = 22, scale = 0)
	public double getMontantDepanseVisit() {
		return this.montantDepanseVisit;
	}

	public void setMontantDepanseVisit(double montantDepanseVisit) {
		this.montantDepanseVisit = montantDepanseVisit;
	}

	@Column(name = "annee", nullable = false)
	public int getAnnee() {
		return this.annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

}
