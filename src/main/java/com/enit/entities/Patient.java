
package com.enit.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Patient implements Serializable{

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(Integer idP, String nom, String prenom, String sexe, String date_Naissance, String adresse,
			String telephone) {
		super();
		this.idP = idP;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		Date_Naissance = date_Naissance;
		this.adresse = adresse;
		this.telephone = telephone;
		
	}
	
	
	@Id
	private Integer idP;
	private String nom;
	private String prenom;
	private String sexe;
	private String Date_Naissance;
	private String adresse;
	private String telephone;
	
	public Integer getIdP() {
		return idP;
	}
	public void setIdP(Integer idP) {
		this.idP = idP;
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
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getDate_Naissance() {
		return Date_Naissance;
	}
	public void setDate_Naissance(String date_Naissance) {
		Date_Naissance = date_Naissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Date_Naissance, adresse, idP, nom, prenom, sexe, telephone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(Date_Naissance, other.Date_Naissance) && Objects.equals(adresse, other.adresse)
				&& Objects.equals(idP, other.idP) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(sexe, other.sexe)
				&& Objects.equals(telephone, other.telephone);
	}
	@Override
	public String toString() {
		return "Patient [idP=" + idP + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", Date_Naissance="
				+ Date_Naissance + ", adresse=" + adresse + ", telephone=" + telephone + "]";
	}

	
	
	
}