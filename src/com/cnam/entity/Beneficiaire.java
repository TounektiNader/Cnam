package com.cnam.entity;
// Generated 20 avr. 2017 00:49:55 by Hibernate Tools 5.2.0.Beta1

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
import javax.persistence.UniqueConstraint;

/**
 * Beneficiaire generated by hbm2java
 */
@Entity
@Table(name = "beneficiaire", catalog = "app_cnam", uniqueConstraints = @UniqueConstraint(columnNames = "CIN"))
public class Beneficiaire implements java.io.Serializable {

	private int codeBenef;
	private Assuresociale assuresociale;
	private String type;
	private int rang;
	private int cin;
	private String nom;
	private String prenom;
	private int age;
	private String adresse;
	private Set<Priseencharge> priseencharges = new HashSet<Priseencharge>(0);

	public Beneficiaire() {
		assuresociale = new Assuresociale();
	}

	public Beneficiaire(int codeBenef, Assuresociale assuresociale, String type, int rang, int cin, String nom,
			String prenom, int age, String adresse) {
		this.codeBenef = codeBenef;
		this.assuresociale = assuresociale;
		this.type = type;
		this.rang = rang;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
	}

	public Beneficiaire(int codeBenef, Assuresociale assuresociale, String type, int rang, int cin, String nom,
			String prenom, int age, String adresse, Set<Priseencharge> priseencharges) {
		this.codeBenef = codeBenef;
		this.assuresociale = assuresociale;
		this.type = type;
		this.rang = rang;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
		this.priseencharges = priseencharges;
	}

	@Id

	@Column(name = "codeBenef", unique = true, nullable = false)
	public int getCodeBenef() {
		return this.codeBenef;
	}

	public void setCodeBenef(int codeBenef) {
		this.codeBenef = codeBenef;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "matriculeAssure", nullable = false)
	public Assuresociale getAssuresociale() {
		return this.assuresociale;
	}

	public void setAssuresociale(Assuresociale assuresociale) {
		this.assuresociale = assuresociale;
	}

	@Column(name = "type", nullable = false, length = 200)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "rang", nullable = false)
	public int getRang() {
		return this.rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	@Column(name = "CIN", unique = true, nullable = false)
	public int getCin() {
		return this.cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	@Column(name = "nom", nullable = false, length = 200)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false, length = 200)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "age", nullable = false)
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "adresse", nullable = false, length = 500)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficiaire")
	public Set<Priseencharge> getPriseencharges() {
		return this.priseencharges;
	}

	public void setPriseencharges(Set<Priseencharge> priseencharges) {
		this.priseencharges = priseencharges;
	}

}
