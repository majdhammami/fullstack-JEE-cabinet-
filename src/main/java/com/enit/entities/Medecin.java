package com.enit.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Medecin implements Serializable{

	@Id
	private String username;
	private String password;
	private String nom;
	private String prenom;
	private String PrixVisite;

	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Medecin(String username, String password, String nom, String prenom, String prixVisite) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		PrixVisite = prixVisite;
	}


	public Medecin(String username) {
		super();
		this.username = username;
	}


	public Medecin(String username, String password, String nom) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
	}


	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getPrixVisite() {
		return PrixVisite;
	}


	public void setPrixVisite(String prixVisite) {
		PrixVisite = prixVisite;
	}


	@Override
	public int hashCode() {
		return Objects.hash(PrixVisite, nom, password, prenom, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medecin other = (Medecin) obj;
		return Objects.equals(PrixVisite, other.PrixVisite) 
				&& Objects.equals(nom, other.nom) && Objects.equals(password, other.password)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "Medecin [username=" + username + ", password=" + password +  ", nom=" + nom + ", prenom="
				+ prenom + ", PrixVisite=" + PrixVisite + "]";
	}
	
	
	
	
}