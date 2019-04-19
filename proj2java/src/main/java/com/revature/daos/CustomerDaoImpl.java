package com.revature.daos;

import com.revature.models.Customer;
import com.revature.utils.SessionFactoryUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class CustomerDaoImpl implements CustomerDao {

    private SessionFactory sf = SessionFactoryUtil.getSessionFactory();
    private Logger log = LogManager.getRootLogger();

    @Override
    public Customer getCustomer(int id) {
        Customer c = null;
        Session session = sf.openSession();

        c = (Customer) session.get(Customer.class, id);
        //log.info(b);
        //System.out.println(b);
        session.close();
        return c;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        s.persist(customer);
        t.commit();
        s.close();

    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteCustomer(int id) {
        // TODO Auto-generated method stub

    }


}
