package org.proxi.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.proxi.spring.model.Compte;
import org.proxi.spring.model.Conseiller;
import org.proxi.spring.model.Customer;
import org.springframework.stereotype.Component;


@Component
public class ControllerConseiller {

	Conseiller conseiller;
	Compte compte;
	Customer customer;
	List<Customer> listeClients = new ArrayList<Customer>();

	public String afficherListeClient(int id) {
		return "page";
	}

	public String ajouterClient(Customer customer) {
		return "page";
	}

	public String modifierClient(Customer customer) {
		return "page";
	}

	public String supprimerClient(Customer customer) {
		return "page";
	}

	public Customer rechercherClient(int idClient) {
		return customer;
	}

	public String virement(Compte compteDebit, Compte compteCredit, int montant) {
		return "page";
	}

	public String alerteSoldeLimit(Compte compte) {
		return "page";
	}

}
