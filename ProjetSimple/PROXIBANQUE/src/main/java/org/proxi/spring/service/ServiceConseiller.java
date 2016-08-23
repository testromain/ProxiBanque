package org.proxi.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.proxi.spring.model.Compte;
import org.proxi.spring.model.Conseiller;
import org.proxi.spring.model.Customer;




public class ServiceConseiller {

	Conseiller conseiller;
	Compte compte;
	Customer customer;
	List<Customer> listeClients = new ArrayList<Customer>();

	public List<Customer> afficherListeClient(int id) {
		return listeClients;
	}

	public void ajouterClient(Customer customer) {
	}

	public void modifierClient(Customer customer) {
	}

	public void supprimerClient(Customer customer) {
	}

	public Customer rechercherClient(int idClient) {
		return customer;
	}

	public void virement(Compte compteDebit, Compte compteCredit, int montant) {
	}

	public void alerteSoldeLimit(Compte compte) {
	}

}
