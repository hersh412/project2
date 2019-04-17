package com.revature.daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.models.User;
import com.revature.utils.SessionFactoryUtil;

@Component
public class UserDaoImpl implements UserDao {
	
	private SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	private Logger log = LogManager.getRootLogger();
	
	public UserDaoImpl() {
		super();
	}

	@Override
	public User getUser(int id) {
		User ret = null;
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		ret = (User) session.get(User.class, id);
		log.info(ret);
		t.commit();
		session.close();
		return ret;
	}

	@Override
	public void saveUser(User user) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.persist(user);
		t.commit();
		s.close();
	}

	@Override
	public void updateUser(String email, User user) {
		//TODO: Remove String email from interface & class
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.update(user);
		t.commit();
		s.close();
		
	}

	@Override
	public void deleteUser(String email) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("DELETE from User where User.email = :p_email");
		q.setString(1, email);
		t.commit();
		s.close();
		
	}

	@Override
	public List<User> getAllUsers() {
		log.info("Getting all users");
		List<User> ul = null;
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("FROM User");
		ul = new ArrayList<User>(q.list());
		t.commit();
		s.close();
		return ul;
	}

	@Override
	public User getUserByEmail(String email) {
		log.info(email);
		User ret = null;
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("FROM User WHERE User.email = :p_email");
		q.setString(1, email);
		ret = (User) q.uniqueResult();
		t.commit();
		session.close();
		return ret;
	}
	
	

}
