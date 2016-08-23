package org.proxi.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

/**
 * @author adminl
 * bean Conseiller
 *
 */

@Component
@Entity
public class Conseiller extends Personne {

	private int id;
	private String login;
	private String mdp;
	private int hierarchie;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="gerant_id")
	private Gerant gerant;

	@OneToMany(mappedBy="conseiller", cascade={CascadeType.REMOVE})
	private Set<Customer> customers=new HashSet<Customer>();
	
	public Conseiller() {
		super();
	}

	public Conseiller(int id, String login, String mdp) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
	}

	
	public Conseiller(int id, String login, String mdp, int hierarchie, Gerant gerant, Set<Customer> customers) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
		this.hierarchie = hierarchie;
		this.gerant = gerant;
		this.customers = customers;
	}
		

	public Conseiller(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getHierarchie() {
		return hierarchie;
	}

	public void setHierarchie(int hierarchie) {
		this.hierarchie = hierarchie;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}


}
