package org.proxi.spring.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.proxi.spring.Dao.CompteDao;
import org.proxi.spring.Dao.CustomerDao;
import org.proxi.spring.Model.Compte;
import org.proxi.spring.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component(value="clientMB")
@ViewScoped
public class CustomerController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	CustomerDao clientService;
	
	@Autowired
	CompteDao compteService;
	
	private Customer bean;
	private Customer beanSelected;
	private List<Customer> list;
	private List<Customer> listSelected;
	private List<String> listCompte;
	
	
	
	@PostConstruct
    public void init() {
		refreshList();
    }
	
	
	public void refreshList() {
		this.bean = new Customer();
		this.beanSelected = new Customer();
		this.list = new ArrayList<Customer>();
		this.listSelected = new ArrayList<Customer>();
		this.listCompte = new ArrayList<String>();
		try {
			this.list.addAll(clientService.findAll());
			this.listSelected.addAll(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void save() {
		try { 
			for(String compteId : listCompte){
				Compte compte = new Compte();
				compte = compteService.findById(Long.parseLong(compteId));
				this.bean.getComptes().add(compte);
			}
			this.bean.setDateCreation(new Date());
			// Use merge instead of persist or you'll have a org.hibernate.PersistentObjectException: detached entity passed to persist: org.slevin.common.Item
			clientService.merge(this.bean);
			refreshList();
			notificationSuccess("persist order");
		} catch (Exception e) {
			notificationError(e,"persist order");
			e.printStackTrace();
		}
	}
	
	public void update() {
		try {
			clientService.merge(this.beanSelected);
			refreshList();
			notificationSuccess("Client modifié");
		} catch (Exception e) {
			notificationError(e,"Client modifié");
		}
	}
	
	
	public void delete() {
		try {
			clientService.remove(this.beanSelected.getIdClient());
			refreshList();
			notificationSuccess("Client supprimé");
		} catch (Exception e) {
			notificationError(e,"Client supprimé");
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
	
	
	public List<Compte> getAllCompte() {
		List<Compte> tmpList = new ArrayList<Compte>();
		try {
			tmpList.addAll(compteService.findAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmpList;
	}


	public CustomerDao getClientService() {
		return clientService;
	}


	public void setClientService(CustomerDao clientService) {
		this.clientService = clientService;
	}


	public Customer getBean() {
		return bean;
	}


	public void setBean(Customer bean) {
		this.bean = bean;
	}


	public Customer getBeanSelected() {
		return beanSelected;
	}


	public void setBeanSelected(Customer beanSelected) {
		this.beanSelected = beanSelected;
	}


	public List<Customer> getList() {
		return list;
	}


	public void setList(List<Customer> list) {
		this.list = list;
	}


	public List<Customer> getListSelected() {
		return listSelected;
	}


	public void setListSelected(List<Customer> listSelected) {
		this.listSelected = listSelected;
	}


	public CompteDao getCompteService() {
		return compteService;
	}


	public void setItemService(CompteDao compteService) {
		this.compteService = compteService;
	}


	public List<String> getListCompte() {
		return listCompte;
	}


	public void setListCompte(List<String> listCompte) {
		this.listCompte = listCompte;
	}


	
	
	
	

}
