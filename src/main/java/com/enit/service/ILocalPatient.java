package com.enit.service;

import java.util.List;


import javax.ejb.Local;

import com.enit.entities.Patient;

@Local
public interface ILocalPatient {

	
	public void ajoutPatient(Patient p);
	
	public List<Patient> lesPatients();
	public Patient chercherPatient(Integer idP);
	public void modifierPatient(Patient p);
	
	public void supprimerPatient(Integer idP);
	

	
}
