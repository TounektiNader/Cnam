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
 * Plafons generated by hbm2java
 */
@Entity
@Table(name = "plafons", catalog = "app_cnam")
public class Plafons implements java.io.Serializable {

	private int codPlafonds;
	private Assuresociale assuresociale;
	private Bulletindesoin bulletindesoin;
	private double montantGlobal;
	private double montantDepenseActe;
	private double montantDepenseVisit;
	private double montantDepenseOrdonannce;
	private double predicat;
	private int annee;

	public Plafons() {
		assuresociale = new Assuresociale();
		bulletindesoin = new Bulletindesoin();
	}

	public Plafons(int codPlafonds, Assuresociale assuresociale, Bulletindesoin bulletindesoin, double montantGlobal,
			double montantDepenseActe, double montantDepenseVisit, double montantDepenseOrdonannce, double predicat,
			int annee) {
		this.codPlafonds = codPlafonds;
		this.assuresociale = assuresociale;
		this.bulletindesoin = bulletindesoin;
		this.montantGlobal = montantGlobal;
		this.montantDepenseActe = montantDepenseActe;
		this.montantDepenseVisit = montantDepenseVisit;
		this.montantDepenseOrdonannce = montantDepenseOrdonannce;
		this.predicat = predicat;
		this.annee = annee;
	}

	@Id

	@Column(name = "codPlafonds", unique = true, nullable = false)
	public int getCodPlafonds() {
		return this.codPlafonds;
	}

	public void setCodPlafonds(int codPlafonds) {
		this.codPlafonds = codPlafonds;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "matriculeAssure", nullable = false)
	public Assuresociale getAssuresociale() {
		return this.assuresociale;
	}

	public void setAssuresociale(Assuresociale assuresociale) {
		this.assuresociale = assuresociale;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codBdeSoin", nullable = false)
	public Bulletindesoin getBulletindesoin() {
		return this.bulletindesoin;
	}

	public void setBulletindesoin(Bulletindesoin bulletindesoin) {
		this.bulletindesoin = bulletindesoin;
	}

	@Column(name = "montantGlobal", nullable = false, precision = 22, scale = 0)
	public double getMontantGlobal() {
		return this.montantGlobal;
	}

	public void setMontantGlobal(double montantGlobal) {
		this.montantGlobal = montantGlobal;
	}

	@Column(name = "MontantDepenseActe", nullable = false, precision = 22, scale = 0)
	public double getMontantDepenseActe() {
		return this.montantDepenseActe;
	}

	public void setMontantDepenseActe(double montantDepenseActe) {
		this.montantDepenseActe = montantDepenseActe;
	}

	@Column(name = "MontantDepenseVisit", nullable = false, precision = 22, scale = 0)
	public double getMontantDepenseVisit() {
		return this.montantDepenseVisit;
	}

	public void setMontantDepenseVisit(double montantDepenseVisit) {
		this.montantDepenseVisit = montantDepenseVisit;
	}

	@Column(name = "MontantDepenseOrdonannce", nullable = false, precision = 22, scale = 0)
	public double getMontantDepenseOrdonannce() {
		return this.montantDepenseOrdonannce;
	}

	public void setMontantDepenseOrdonannce(double montantDepenseOrdonannce) {
		this.montantDepenseOrdonannce = montantDepenseOrdonannce;
	}

	@Column(name = "predicat", nullable = false, precision = 22, scale = 0)
	public double getPredicat() {
		return this.predicat;
	}

	public void setPredicat(double predicat) {
		this.predicat = predicat;
	}

	@Column(name = "annee", nullable = false)
	public int getAnnee() {
		return this.annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

}
