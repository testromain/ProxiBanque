package org.proxi.spring.DaoImpl;


import org.proxi.spring.Dao.CustomerDao;
import org.proxi.spring.Model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CustomerDaoImpl extends ProxiBanqueDaoImpl<Customer> implements CustomerDao {

}
