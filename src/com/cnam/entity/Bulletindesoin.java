package com.cnam.entity;
// Generated 20 avr. 2017 00:49:55 by Hibernate Tools 5.2.0.Beta1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Bulletindesoin generated by hbm2java
 */
@Entity
@Table(name = "bulletindesoin", catalog = "app_cnam")
public class Bulletindesoin implements java.io.Serializable {

	private int codBdeSoin;
	private Centrecnam centrecnam;
	private Date dateDepot;
	private int numero;
	private Date dateVisite;
	private double totalOrdonnance;
	private double totalActes;
	private double totalVisit;
	private double totalrembourse;
	private Date dateVirement;
	private String etat;
	private Set<Bsmedicament> bsmedicaments = new HashSet<Bsmedicament>(0);
	private Set<Bsacte> bsactes = new HashSet<Bsacte>(0);
	private Set<Bsvisit> bsvisits = new HashSet<Bsvisit>(0);
	private Set<Plafons> plafonses = new HashSet<Plafons>(0);

	public Bulletindesoin() {
		centrecnam = new Centrecnam();
	}

	public Bulletindesoin(int codBdeSoin, Centrecnam centrecnam, Date dateDepot, int numero, Date dateVisite,
			double totalOrdonnance, double totalActes, double totalVisit, double totalrembourse, Date dateVirement,
			String etat) {
		this.codBdeSoin = codBdeSoin;
		this.centrecnam = centrecnam;
		this.dateDepot = dateDepot;
		this.numero = numero;
		this.dateVisite = dateVisite;
		this.totalOrdonnance = totalOrdonnance;
		this.totalActes = totalActes;
		this.totalVisit = totalVisit;
		this.totalrembourse = totalrembourse;
		this.dateVirement = dateVirement;
		this.etat = etat;
	}

	public Bulletindesoin(int codBdeSoin, Centrecnam centrecnam, Date dateDepot, int numero, Date dateVisite,
			double totalOrdonnance, double totalActes, double totalVisit, double totalrembourse, Date dateVirement,
			String etat, Set<Bsmedicament> bsmedicaments, Set<Bsacte> bsactes, Set<Bsvisit> bsvisits,
			Set<Plafons> plafonses) {
		this.codBdeSoin = codBdeSoin;
		this.centrecnam = centrecnam;
		this.dateDepot = dateDepot;
		this.numero = numero;
		this.dateVisite = dateVisite;
		this.totalOrdonnance = totalOrdonnance;
		this.totalActes = totalActes;
		this.totalVisit = totalVisit;
		this.totalrembourse = totalrembourse;
		this.dateVirement = dateVirement;
		this.etat = etat;
		this.bsmedicaments = bsmedicaments;
		this.bsactes = bsactes;
		this.bsvisits = bsvisits;
		this.plafonses = plafonses;
	}

	@Id

	@Column(name = "codBdeSoin", unique = true, nullable = false)
	public int getCodBdeSoin() {
		return this.codBdeSoin;
	}

	public void setCodBdeSoin(int codBdeSoin) {
		this.codBdeSoin = codBdeSoin;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CodeCnam", nullable = false)
	public Centrecnam getCentrecnam() {
		return this.centrecnam;
	}

	public void setCentrecnam(Centrecnam centrecnam) {
		this.centrecnam = centrecnam;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateDepot", nullable = false, length = 10)
	public Date getDateDepot() {
		return this.dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	@Column(name = "numero", nullable = false)
	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateVisite", nullable = false, length = 10)
	public Date getDateVisite() {
		return this.dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	@Column(name = "totalOrdonnance", nullable = false, precision = 22, scale = 0)
	public double getTotalOrdonnance() {
		return this.totalOrdonnance;
	}

	public void setTotalOrdonnance(double totalOrdonnance) {
		this.totalOrdonnance = totalOrdonnance;
	}

	@Column(name = "totalActes", nullable = false, precision = 22, scale = 0)
	public double getTotalActes() {
		return this.totalActes;
	}

	public void setTotalActes(double totalActes) {
		this.totalActes = totalActes;
	}

	@Column(name = "totalVisit", nullable = false, precision = 22, scale = 0)
	public double getTotalVisit() {
		return this.totalVisit;
	}

	public void setTotalVisit(double totalVisit) {
		this.totalVisit = totalVisit;
	}

	@Column(name = "totalrembourse", nullable = false, precision = 22, scale = 0)
	public double getTotalrembourse() {
		return this.totalrembourse;
	}

	public void setTotalrembourse(double totalrembourse) {
		this.totalrembourse = totalrembourse;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateVirement", nullable = false, length = 10)
	public Date getDateVirement() {
		return this.dateVirement;
	}

	public void setDateVirement(Date dateVirement) {
		this.dateVirement = dateVirement;
	}

	@Column(name = "etat", nullable = false, length = 300)
	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bulletindesoin")
	public Set<Bsmedicament> getBsmedicaments() {
		return this.bsmedicaments;
	}

	public void setBsmedicaments(Set<Bsmedicament> bsmedicaments) {
		this.bsmedicaments = bsmedicaments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bulletindesoin")
	public Set<Bsacte> getBsactes() {
		return this.bsactes;
	}

	public void setBsactes(Set<Bsacte> bsactes) {
		this.bsactes = bsactes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bulletindesoin")
	public Set<Bsvisit> getBsvisits() {
		return this.bsvisits;
	}

	public void setBsvisits(Set<Bsvisit> bsvisits) {
		this.bsvisits = bsvisits;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bulletindesoin")
	public Set<Plafons> getPlafonses() {
		return this.plafonses;
	}

	public void setPlafonses(Set<Plafons> plafonses) {
		this.plafonses = plafonses;
	}

}