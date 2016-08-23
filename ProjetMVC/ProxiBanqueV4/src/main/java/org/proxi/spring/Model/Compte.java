package org.proxi.spring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.proxi.spring.Model.Customer;

@Entity
//@NamedQueries({
//    @NamedQuery(name="compte.findAll", query="SELECT FROM CUSTOMER"),
//}) 
public class Compte extends Personne {

	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCompte;
	
	@ManyToOne
	private Customer client;

	private String typeCompte;
	
	private double solde;
	
	
	/**
	 * @return the client
	 */
	public Customer getClient() {
		return client;
	}

	/**
	 * @return the compte
	 */
	public String getTypeCompte() {
		return typeCompte;
	}

	/**
	 * @param 
	 */
	public void setProduct(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

		/**
	 * @return the id
	 */
	public Long getIdCompte() {
		return idCompte;
	}
	
	
}
