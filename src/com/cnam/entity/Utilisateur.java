package com.cnam.entity;
// Generated 20 avr. 2017 00:49:55 by Hibernate Tools 5.2.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Utilisateur generated by hbm2java
 */
@Entity
@Table(name = "utilisateur", catalog = "app_cnam", uniqueConstraints = @UniqueConstraint(columnNames = "codUser"))
public class Utilisateur implements java.io.Serializable {

	private Integer iduser;
	private int codUser;
	private String userName;

	public Utilisateur() {
	}

	public Utilisateur(int codUser, String userName) {
		this.codUser = codUser;
		this.userName = userName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "IDUser", unique = true, nullable = false)
	public Integer getIduser() {
		return this.iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	@Column(name = "codUser", unique = true, nullable = false)
	public int getCodUser() {
		return this.codUser;
	}

	public void setCodUser(int codUser) {
		this.codUser = codUser;
	}

	@Column(name = "UserName", nullable = false, length = 500)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}