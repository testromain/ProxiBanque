package org.proxi.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;


/**
 * @author adminl
 * bean Gerant
 *
 */
@Component
@Entity
public class Gerant extends Conseiller{

	
	@OneToMany(mappedBy="gerant", cascade={CascadeType.REMOVE})
	private Set<Conseiller> conseillers=new HashSet<Conseiller>();
	
	public Gerant() {
		super();
		
	}

	public Set<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(Set<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

	public Gerant(Set<Conseiller> conseillers) {
		super();
		this.conseillers = conseillers;
	}

	public Gerant(int id, String login, String mdp, int hierarchie, Gerant gerant, Set<Customer> customers) {
		super(id, login, mdp, hierarchie, gerant, customers);
		// TODO Auto-generated constructor stub
	}

	public Gerant(int id, String login, String mdp) {
		super(id, login, mdp);
		// TODO Auto-generated constructor stub
	}

	public Gerant(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

}
