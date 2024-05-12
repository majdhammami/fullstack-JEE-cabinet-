package com.enit.service;

import java.util.List;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.enit.entities.Consultation;
import com.enit.entities.Medicament;
import com.enit.entities.Patient;



@Stateless

public class LocalConsultationImpl  implements ILocalConsultation{

	
	@PersistenceContext(unitName="UP_CONSULTATION")
	EntityManager em;
	
	@Override
	public void ajoutConsultation(Consultation consultation) {
		// TODO Auto-generated method stub
		em.merge(consultation);
		
	}

	@Override
	public List<Consultation> tousLesConsultations() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select c from Consultation c");
		return req.getResultList();	}

	@Override
	public void supprimerConsultation(Integer idC) {
		// TODO Auto-generated method stub
		em.remove(em.find(Consultation.class, idC));
	}

	@Override
	public Consultation chercherConsultation(Integer idC) {
		// TODO Auto-generated method stub
		return em.find(Consultation.class, idC);
	}
	
	@Override
	public boolean existeConsultation(Integer idC) {
		// TODO Auto-generated method stub
		if (em.find(Consultation.class, idC)!=null)
		{
			 return true;
		}
		else return false;
	}
	
	
	
	
	

}
