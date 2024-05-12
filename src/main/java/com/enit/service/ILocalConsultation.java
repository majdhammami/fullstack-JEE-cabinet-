package com.enit.service;

import java.util.List;


import javax.ejb.Local;


import com.enit.entities.Consultation;
import com.enit.entities.Medicament;

@Local
public interface ILocalConsultation {
	
	public void ajoutConsultation(Consultation consultation);
	public void supprimerConsultation(Integer idC);
	public Consultation chercherConsultation(Integer idC);

	public List<Consultation> tousLesConsultations();
	public boolean existeConsultation(Integer idC);

}
