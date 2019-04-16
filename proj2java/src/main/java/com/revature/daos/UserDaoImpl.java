package com.revature.daos;

import com.revature.models.User;
import com.revature.utils.SessionFactoryUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
	
	private SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	private Logger log = LogManager.getRootLogger();

	@Override
	public User getUser(int id) {
	    log.info("**IN USERDAO**");
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
		log.info("Attempting to get user by: " + email);
		User ret = null;
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("FROM User WHERE User.email = :p_email");
		q.setString(1, email);
		ret = (User) q.uniqueResult();
		if (ret == null) {
			log.info("Unable to find user for email " + email);
		}
		t.commit();
		session.close();
		log.info("dao: " + ret.toString());
		return ret;
	}
	
	

}
