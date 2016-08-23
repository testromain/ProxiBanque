package org.proxi.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.proxi.spring.model.Conseiller;
import org.proxi.spring.model.Customer;
import org.proxi.spring.model.OperationCompte;
import org.springframework.stereotype.Component;

@Component("daoConseiller")
public class DaoConseiller {
	private Conseiller conseiller;
	private Customer customer;
	private List<Customer> listCustomers;

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque");
	EntityManager em = emf.createEntityManager();

	public List<Customer> afficherListeCustomer(int id) {
		return listCustomers;
	}

	public void ajouterCustomer(Customer customer) {
		em.persist(customer);
		System.out.println("dao");
	}

	public void modifierCustomer(Customer customer) {
	}

	public void supprimerCustomer(Customer customer) {
		em.remove(em.find(Customer.class, customer.getIdClient()));
		
		
	}

	public Customer rechercherCustomer(int idClient) {
		return customer;
	}

	public void virement(OperationCompte compteDebit, OperationCompte compteCredit, int montant) {
	}

	public void alerteSoldeLimit(OperationCompte compte) {
	}

}
