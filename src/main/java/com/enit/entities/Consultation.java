package com.enit.entities;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Consultation implements Serializable {

	
	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consultation(Integer idC, String dateRDV, String heureRDV) {
		super();
		this.idC = idC;
		DateRDV = dateRDV;
		HeureRDV = heureRDV;
	}

    @Id
	private Integer idC;
	private String DateRDV;
	private String HeureRDV;
	//private String mede;

	
	
	@ManyToOne /*(cascade = CascadeType.MERGE)*/
	private Medecin intervenant;
	@ManyToOne/*(cascade = CascadeType.MERGE)*/
	private Patient patient;

	@ManyToMany(fetch = FetchType.EAGER)

	private Collection<Medicament> Med = new ArrayList<Medicament>();

	

	private int nbMedicaments = 0;


	public Consultation(Patient patient) {
		super();
		this.patient = patient;
	}

	public Consultation(Integer idC, String dateRDV, String heureRDV, Medecin intervenant) {
		super();
		this.idC = idC;
		DateRDV = dateRDV;
		HeureRDV = heureRDV;
		this.intervenant = intervenant;
	}

	public Integer getIdC() {
		return idC;
	}


	public void setIdC(Integer idC) {
		this.idC = idC;
	}


	public String getDateRDV() {
		return DateRDV;
	}


	public void setDateRDV(String dateRDV) {
		DateRDV = dateRDV;
	}


	public String getHeureRDV() {
		return HeureRDV;
	}


	public void setHeureRDV(String heureRDV) {
		HeureRDV = heureRDV;
	}


	public Medecin getIntervenant() {
		return intervenant;
	}


	public void setIntervenant(Medecin intervenant) {
		this.intervenant = intervenant;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Collection<Medicament> getMed() {
		return Med;
	}


	public void setMed(Collection<Medicament> med) {
		Med = med;
	}


	public Consultation(Integer idC, String dateRDV, String heureRDV, int nbMedicaments) {
		super();
		this.idC = idC;
		DateRDV = dateRDV;
		HeureRDV = heureRDV;
		this.nbMedicaments = nbMedicaments;
	}

	public Consultation(Integer idC, String dateRDV, String heureRDV, Medecin intervenant, Patient patient,
			Collection<Medicament> med, int nbMedicaments) {
		super();
		this.idC = idC;
		DateRDV = dateRDV;
		HeureRDV = heureRDV;
		this.intervenant = intervenant;
		this.patient = patient;
		Med = med;
		this.nbMedicaments = nbMedicaments;
	}

	public int getNbMedicaments() {
		return nbMedicaments;
	}

	public void setNbMedicaments(int nbMedicaments) {
		this.nbMedicaments = nbMedicaments;
	}

	
	
	public void ajouterMedicament (Medicament Me)
	{
	
		if (Med== null)
		{
		System.out.println("wooooooooooooooooooooooooh");
			
		}
		else
		{
			Med.add(Me) ;
			nbMedicaments ++;
		}
			
			
		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DateRDV == null) ? 0 : DateRDV.hashCode());
		result = prime * result + ((HeureRDV == null) ? 0 : HeureRDV.hashCode());
		result = prime * result + ((Med == null) ? 0 : Med.hashCode());
		result = prime * result + ((idC == null) ? 0 : idC.hashCode());
		result = prime * result + ((intervenant == null) ? 0 : intervenant.hashCode());
		result = prime * result + nbMedicaments;
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consultation other = (Consultation) obj;
		if (DateRDV == null) {
			if (other.DateRDV != null)
				return false;
		} else if (!DateRDV.equals(other.DateRDV))
			return false;
		if (HeureRDV == null) {
			if (other.HeureRDV != null)
				return false;
		} else if (!HeureRDV.equals(other.HeureRDV))
			return false;
		if (Med == null) {
			if (other.Med != null)
				return false;
		} else if (!Med.equals(other.Med))
			return false;
		if (idC == null) {
			if (other.idC != null)
				return false;
		} else if (!idC.equals(other.idC))
			return false;
		if (intervenant == null) {
			if (other.intervenant != null)
				return false;
		} else if (!intervenant.equals(other.intervenant))
			return false;
		if (nbMedicaments != other.nbMedicaments)
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Consultation [idC=" + idC + ", DateRDV=" + DateRDV + ", HeureRDV=" + HeureRDV + ", intervenant="
				+ intervenant + ", patient=" + patient + ", Med=" + Med + ", nbMedicaments=" + nbMedicaments + "]";
	}
	
	


	
	
	
	
}
