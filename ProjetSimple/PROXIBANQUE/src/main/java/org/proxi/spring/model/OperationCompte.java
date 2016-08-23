package org.proxi.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;

import org.springframework.stereotype.Component;

/**
 * @author adminl
 * bean historique operation sur les compte
 *
 */
@Component
@Entity
public class OperationCompte extends Compte {

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateOperation;
	private float montant;

	public OperationCompte(Long numCompte, String typeCompte, float solde, Date dateOperation, float montant) {
		super(numCompte, typeCompte, solde);
		this.dateOperation = dateOperation;
		this.montant = montant;
	}

	public OperationCompte() {
		super();
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

}
