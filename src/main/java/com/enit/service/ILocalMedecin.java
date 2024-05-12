package com.enit.service;

import java.util.List;


import javax.ejb.Local;

import com.enit.entities.Medecin;
import com.enit.entities.Medicament;

@Local
public interface ILocalMedecin {
	public void insertMedecin(Medecin m);
	//public Medecin getMedecin(Integer idM);
	public Medecin getMedecin(String username);

	public List<Medecin> lesMedecins();

}
