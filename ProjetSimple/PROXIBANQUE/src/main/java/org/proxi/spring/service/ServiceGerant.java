package org.proxi.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.proxi.spring.model.Conseiller;

public class ServiceGerant {

	Conseiller conseiller;
	List<Conseiller> listeConseillers = new ArrayList<Conseiller>();
	List<String> listeTransaction = new ArrayList<String>();

	public List<Conseiller> afficherListeConseiller(int id) {
		return listeConseillers;
	}

	public List<String> afficherPage() {
		return listeTransaction;
	}

}
