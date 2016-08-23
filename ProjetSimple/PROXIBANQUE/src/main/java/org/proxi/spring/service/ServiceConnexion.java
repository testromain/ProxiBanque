package org.proxi.spring.service;

public class ServiceConnexion {

	private String login;
	private String mdp;
	private String cnx;

	public String connexion(String login, String mdp) {
		return "type de connexion (gerant ou conseiller)";
	}

	public Boolean deconnexion(String login, String mdp) {
		return true;
	}

}
