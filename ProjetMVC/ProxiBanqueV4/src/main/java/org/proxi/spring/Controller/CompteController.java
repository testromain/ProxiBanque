package org.proxi.spring.Controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.proxi.spring.Dao.CompteDao;
import org.proxi.spring.Model.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component(value="compteController")
@ViewScoped
public class CompteController implements Serializable {

	private static final long serialVersionUID = 1L;


	@Autowired
	private CompteDao compteService;

	private Compte bean;
	private Compte beanSelected;
	private List<Compte> list;
	private List<Compte> listSelected;
	
	@PostConstruct
    public void init() {
		refreshList();
    }



	public void refreshList() {
		this.bean = new Compte();
		this.beanSelected = new Compte();
		this.list = new ArrayList<Compte>();
		this.listSelected = new ArrayList<Compte>();
		try {
			this.list.addAll(compteService.findAll());
			this.listSelected.addAll(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public void save() {
		try {
		    
			compteService.persist(this.bean);
			refreshList();
			notificationSuccess("persist item");
		} catch (Exception e) {
			notificationError(e,"persist item");
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			compteService.merge(this.beanSelected);
			refreshList();
			notificationSuccess("update item");
		} catch (Exception e) {
			notificationError(e,"update item");
		}
	}

	public void delete() {
		try {
			compteService.remove(this.beanSelected.getIdCompte());
			refreshList();
			notificationSuccess("Compte supprimé");
		} catch (Exception e) {
			notificationError(e,"Compte supprimé");
		}
	}

	public void onCancel(RowEditEvent event) {
		refreshList();
	}

	
	public void reset() {
		refreshList();
        RequestContext.getCurrentInstance().reset("form1:panel");  
	}

	
	public void notificationSuccess(String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation "+operation+" success");
		FacesMessage msg = null;  
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success"); 
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}


	public void notificationError(Exception e, String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation "+operation+" Error ",e);
		FacesMessage msg = null;  
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");  
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}
	
	public CompteDao getCompteService() {
		return compteService;
	}

	public void setItemService(CompteDao compteService) {
		this.compteService = compteService;
	}

	public Compte getBean() {
		return bean;
	}

	public void setBean(Compte bean) {
		this.bean = bean;
	}

	public Compte getBeanSelected() {
		return beanSelected;
	}

	public void setBeanSelected(Compte beanSelected) {
		this.beanSelected = beanSelected;
	}

	public List<Compte> getList() {
		if(list == null){
			list = new ArrayList<Compte>();
		}
		return list;
	}

	public void setList(List<Compte> list) {
		this.list = list;
	}

	public List<Compte> getListSelected() {
		return listSelected;
	}

	public void setListSelected(List<Compte> listSelected) {
		this.listSelected = listSelected;
	}

	
	
	
	
}
