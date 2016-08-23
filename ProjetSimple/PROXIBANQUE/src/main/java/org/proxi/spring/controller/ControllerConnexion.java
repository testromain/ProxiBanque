package org.proxi.spring.controller;

import org.springframework.stereotype.Component;

@Component
public class ControllerConnexion {

	private String login;
	private String mdp;
	private String cnx;

	public String connexion(String login, String mdp) {
		return "Virement";
	}

	public String deconnexion(String login, String mdp) {
		return "page";
	}

}
