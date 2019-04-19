package com.revature.daos;

import com.revature.models.Policy;
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
public class PolicyDaoImpl implements PolicyDao {

    private SessionFactory sf = SessionFactoryUtil.getSessionFactory();
    private Logger log = LogManager.getRootLogger();

    @Override
    public Policy getPolicyById(int id) {
        Policy ret = null;
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        ret = (Policy) session.get(Policy.class, id);
        t.commit();
        session.close();
        return ret;
    }

    @Override
    public List<Policy> getPoliciesByOwnerId(int policyOwner) {
        List<Policy> ret = null;
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("from Policy p where policyOwner = :p_ownerId");
        q.setInteger("p_ownerId", policyOwner);
        ret = new ArrayList<Policy>(q.list());
        t.commit();
        session.close();
        return ret;
    }


}
