package org.proxi.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author adminl bean compte
 *
 */
@Component
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numCompte;
	private String typeCompte;
	private float solde;

	/**
	 * Dependance client
	 */
	@Autowired
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "client_id")
	private Customer client;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(Long numCompte, String typeCompte, float solde) {
		super();
		this.numCompte = numCompte;
		this.typeCompte = typeCompte;
		this.solde = solde;
	}

	public Compte(Long numCompte, String typeCompte, float solde, Customer client) {
		super();
		this.numCompte = numCompte;
		this.typeCompte = typeCompte;
		this.solde = solde;
		this.client = client;
	}

	public Long getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(Long numCompte) {
		this.numCompte = numCompte;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Customer getClient() {
		return client;
	}

	public void setClient(Customer client) {
		this.client = client;
	}

}
