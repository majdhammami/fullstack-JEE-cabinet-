package com.enit.service;
import java.util.List;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.enit.entities.Medicament;
@Stateless
public class LocalMedicament implements ILocalMedicament {
	@PersistenceContext(unitName="UP_CONSULTATION")
	EntityManager em1;

	@Override
	public void ajoutMedicament(Medicament m) {
		// TODO Auto-generated method stub
		em1.merge(m);

	}

	@Override
	public List<Medicament> lesMedicaments() {
		// TODO Auto-generated method stub
		Query req=em1.createQuery("select m from Medicament m");
		return req.getResultList();		}

	@Override
	public Medicament chercherMedicament(Integer idME) {
		// TODO Auto-generated method stub
		return em1.find(Medicament.class, idME);
	}

	@Override
	public Medicament chercherMedicament(String nom) {
		// TODO Auto-generated method stub
		return em1.find(Medicament.class, nom);
	}

	@Override
	public void modifierMedicament(Medicament m) {
		// TODO Auto-generated method stub
		em1.merge(m) ;

		
	}

	@Override
	public void supprimerMedicament(Integer idME) {
		// TODO Auto-generated method stub
		em1.remove(chercherMedicament(idME));

	}
	
	
	

}
