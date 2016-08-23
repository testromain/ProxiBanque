package org.proxi.spring.testsUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.proxi.spring.Dao.CompteDao;
import org.proxi.spring.Dao.CustomerDao;
import org.proxi.spring.Model.Compte;
import org.proxi.spring.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class persistenceTests {

		@PersistenceContext
		private EntityManager entityManager;
		
		@Autowired
		CustomerDao clientDao;
		
		@Autowired
		CompteDao compteDao;
		
		@Test
		@Transactional
		public void testSaveClientavecCompte() throws Exception {
//			assertNotNull(order.getId());
			Customer client=new Customer();
			client.getComptes().add(new Compte());
			entityManager.persist(client);
			entityManager.flush();
			assertNotNull(client.getIdClient());
		}

		/*@Test
		@Transactional
		public void testSaveAndGet() throws Exception {
//			Order order = new Order();
//			order.getItems().add(new Item());
//			entityManager.persist(order);
//			entityManager.flush();
//			// Otherwise the query returns the existing order (and we didn't set the
//			// parent in the item)...
//			entityManager.clear();
//			Order other = (Order) entityManager.find(Order.class, order.getId());
//			assertEquals(1, other.getItems().size());
//			assertEquals(other, other.getItems().iterator().next().getOrder());
		}

		@Test
		@Transactional
		public void testSaveAndFind() throws Exception {
//			Order order = new Order();
//			Item item = new Item();
//			item.setProduct("foo");
//			order.getItems().add(item);
//			entityManager.persist(order);
//			entityManager.flush();
//			// Otherwise the query returns the existing order (and we didn't set the
//			// parent in the item)...
//			entityManager.clear();
//			Order other = (Order) entityManager
//					.createQuery(
//							"select o from Order o join o.items i where i.product=:product")
//					.setParameter("product", "foo").getSingleResult();
//			assertEquals(1, other.getItems().size());
//			assertEquals(other, other.getItems().iterator().next().getOrder());
		}
		*/
}
		