package com.enit.service;

import java.util.List;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.enit.entities.Patient;
@Stateless
public class LocalPatientImpl implements ILocalPatient {

	@PersistenceContext(unitName="UP_CONSULTATION")
	EntityManager em2;
	@Override
	public void ajoutPatient(Patient p) {
		// TODO Auto-generated method stub
		em2.merge(p);
	}

	@Override
	public List<Patient> lesPatients() {
		// TODO Auto-generated method stub
		Query req=em2.createQuery("select p from Patient p");
		return req.getResultList();		}

	@Override
	public Patient chercherPatient(Integer idP) {
		// TODO Auto-generated method stub
		return em2.find(Patient.class, idP);
	}

	@Override
	public void modifierPatient(Patient p) {
		// TODO Auto-generated method stub
		em2.merge(p) ;
		
	}

	@Override
	public void supprimerPatient(Integer idP) {
		// TODO Auto-generated method stub
		em2.remove(chercherPatient(idP));
	}
	
	

	


}