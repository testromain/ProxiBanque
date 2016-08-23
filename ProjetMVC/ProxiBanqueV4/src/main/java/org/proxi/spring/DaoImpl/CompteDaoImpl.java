package org.proxi.spring.DaoImpl;


import org.proxi.spring.Dao.CompteDao;
import org.proxi.spring.Model.Compte;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class CompteDaoImpl extends ProxiBanqueDaoImpl<Compte> implements CompteDao {

	
}

