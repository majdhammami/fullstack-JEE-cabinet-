package com.enit.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicament implements Serializable {
	
	@Id
	private Integer idME;
	private String nom;
	private String dosage;
	
	
	public Medicament() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Medicament(Integer idME, String nom, String dosage) {
		super();
		this.idME = idME;
		this.nom = nom;
		this.dosage = dosage;
	}


	public Integer getIdME() {
		return idME;
	}


	public void setIdME(Integer idME) {
		this.idME = idME;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDosage() {
		return dosage;
	}


	public void setDosage(String dosage) {
		this.dosage = dosage;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idME, nom, dosage);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicament other = (Medicament) obj;
		return Objects.equals(idME, other.idME) && Objects.equals(nom, other.nom) && Objects.equals(dosage, other.dosage);
	}


	@Override
	public String toString() {
		return "Medicament [idME=" + idME + ", nom=" + nom + ", dosage=" + dosage + "]";
	}


	public Medicament(String nom) {
		super();
		this.nom = nom;
	}
	
	
	

}
