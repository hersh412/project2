package com.revature.daos;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.models.Auth;
import com.revature.models.User;
import com.revature.utils.SessionFactoryUtil;

@Component
public class AuthDaoImpl implements AuthDao {
	private SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	private Logger log = LogManager.getRootLogger();
	
	@Override
	public void deleteExpiredAuth(String key) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("DELETE from Auth where Auth.key = :p_key");
		q.setString(1, key);
		t.commit();
		s.close();

	}

	@Override
	public void createAuth(Auth auth) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		log.log(Level.INFO, auth);
		s.save(auth);
		t.commit();
		s.close();

	}

	@Override
	public Auth getAuth(String key) {
		Auth a = null;
		Session session = sf.openSession();
		
		a = (Auth) session.get(Auth.class, key);
		//log.info(b);
		//System.out.println(b);
		session.close();
		return a;
	}
}


