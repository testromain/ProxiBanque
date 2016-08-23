package org.proxi.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component("daoConnexion")
public class DaoConnexion<E> {

	private String login;
	private String mdp;
	private String cnx;
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxybanque");
	EntityManager em = emf.createEntityManager();
	
	protected E instance;
	private Class<E> entityClass;


		public Class<E> getEntityClass() {
		return entityClass;
	}



	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}



//		public Conseiller connexion(String login, String pwd) throws Exception{
///*			Conseiller conseiller=(Conseiller) getEntityManager().createQuery("Select t from "+ getEntityClass().getSimpleName() +" t where login=x."+login+" and password = x." +pwd).getSingleResult();
//			if(conseiller==null){
//				Gerant gerant= (Gerant) getEntityManager().createQuery("Select t from "+ getEntityClass().getSimpleName() +" t where login=x."+login+" and password = x." +pwd).getSingleResult();
//				if(gerant==null){
//					return null;
//				}else{
//					return gerant; 
//				}
//			}else{
//				return conseiller;
//			}*/
//			Conseiller conseiller=(Conseiller) getEntityManager().createQuery("Select t from "+ getEntityClass().getSimpleName() +" t where login=x."+login+" and password = x." +pwd).getSingleResult();
//			if(conseiller==null){
//					return null; 				
//			}else{
//				return conseiller;
//			}
//			
//		}
//
//		
//	
//	public EntityManager getEntityManager() {
//			return entityManager;
//		}
//
//
//
//		public void setEntityManager(EntityManager entityManager) {
//			this.entityManager = entityManager;
//		}
//
//
//
//	private String deconnection(String login, String mdp){
//		return "deconnection";
//	}
//	
}
