package com.enit.service;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.enit.entities.Medecin;


@Stateless


public class LocalMedecinImpl implements ILocalMedecin {
	
	@PersistenceContext(unitName="UP_CONSULTATION")
	EntityManager em4;

	@Override
	public void insertMedecin(Medecin m) {
		// TODO Auto-generated method stub
		em4.merge(m);

			}
				

	/*@Override
	public Medecin getMedecin(Integer idM) {
		 return em4.find(Medecin.class, idM);
				
			}*/


	@Override
	public Medecin getMedecin(String username) {
		// TODO Auto-generated method stub
		 return em4.find(Medecin.class, username) ;
		 
				 
	}


	@Override
	public List<Medecin> lesMedecins() {
		// TODO Auto-generated method stub
		Query req=em4.createQuery("select m from Medecin m");
		return req.getResultList();		}

	

	
	}
		


