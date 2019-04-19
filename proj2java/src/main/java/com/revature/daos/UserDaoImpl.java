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

    public UserDaoImpl() {
        super();
    }

    @Override
    public User getUser(int id) {
        User u = null;
        Session session = sf.openSession();

        u = (User) session.get(User.class, id);
        //log.info(b);
        //System.out.println(b);
        session.close();
        return u;
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


    /**
     * This method searches the database for a user based on the email addressed provided in the argument.
     * It will return exactly 1 User object if found, or null.
     *
     * @param email : String email address to search for
     * @return User or null
     */
    @Override
    public User getUserByEmail(String email) {
        User ret = null;
        log.info("Getting user with email: " + email);
        Session session = sf.openSession();
        Query q = session.createQuery("from User u where u.email = :p_email");
        ret = (User) q.setString(1, email).uniqueResult();
        session.close();
        return ret;
//        Criteria c = session.createCriteria(User.class);
//        c.add(Restrictions.ilike("email", email));
//        Set<User> users = new HashSet<User>(c.list());
//        session.close();
//        return (User) users.toArray()[0];
    }

}
