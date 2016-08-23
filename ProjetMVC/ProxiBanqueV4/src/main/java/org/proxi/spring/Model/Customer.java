package org.proxi.spring.Model;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.proxi.spring.Model.Compte;

@Entity
@Table(name="T_ORDER")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idClient;
	
	private String adresse;
	
	private String mail;
	
	private Date dateCreation;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ORDER_IDCOMPTE")
	private Collection<Compte> comptes = new LinkedHashSet<Compte>();

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param customer the adresse to set
	 */
	public void setCustomer(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return compte
	 */
	public Collection<Compte> getComptes() {
		return comptes;
	}

	/**
	 * @param items the items to set
	 */
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	/**
	 * @return the id
	 */
	public Long getIdClient() {
		return idClient;
	}

	public String getMail() {
		return mail;
	}

	public void setReference(String mail) {
		this.mail = mail;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


//	public Customer(String nom, String prenom, Long idClient, String adresse, String mail) {
//		super(nom,prenom);
//		this.idClient = idClient;
//		this.adresse = adresse;
//		this.mail = mail;
//	}
//	

	


	

}
