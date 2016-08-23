package org.proxi.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

/**
 * @author adminl
 * bean customer 
 *
 */
@Component
@Entity
public class Customer extends Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idClient;
	private String adresse;
	private String mail;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="conseiller_id")
	private Conseiller conseiller;

	@OneToMany(mappedBy="client", cascade={CascadeType.REMOVE})
	private Set<Compte> comptes=new HashSet<Compte>();


	public Customer() {
		super();
	}

	public Customer(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int idClient, String nom, String prenom, String adresse, String mail) {
		super(nom, prenom);
		this.idClient = idClient;
		this.adresse = adresse;
		this.mail = mail;
	}


	public Customer(int idClient, String nom, String prenom, String adresse, String mail, Conseiller conseiller) {
		super(nom, prenom);
		this.idClient = idClient;
		this.adresse = adresse;
		this.mail = mail;
		this.conseiller = conseiller;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

}
