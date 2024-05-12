package com.enit.service;

import java.util.List;


import javax.ejb.Local;

import com.enit.entities.Medicament;

@Local
public interface ILocalMedicament {
	
public void ajoutMedicament(Medicament m);
	
	public List<Medicament> lesMedicaments();
	public Medicament chercherMedicament(Integer idME);
	public Medicament chercherMedicament(String nom);

	public void modifierMedicament(Medicament m);
	
	public void supprimerMedicament(Integer idME);
}
