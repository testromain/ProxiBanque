package org.proxi.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.proxi.spring.model.Conseiller;
import org.springframework.stereotype.Component;


@Component
public class ControllerGerant {

	Conseiller conseiller;
	List<Conseiller> listeConseillers = new ArrayList<Conseiller>();
	List<String> listeTransaction = new ArrayList<String>();

	public String afficherListeConseiller(int id) {
		return "page";
	}

	public String afficherPage() {
		return "page";
	}

}
