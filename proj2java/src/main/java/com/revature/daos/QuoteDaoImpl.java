package com.revature.daos;

import com.revature.models.Quote;
import com.revature.utils.SessionFactoryUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class QuoteDaoImpl implements QuoteDao {
    private SessionFactory sf = SessionFactoryUtil.getSessionFactory();
    private Logger log = LogManager.getRootLogger();

    @Override
    public void saveQuote(Quote quote) {
        Session sess = sf.openSession();
        Transaction t = sess.beginTransaction();
        sess.persist(quote);
        log.info("Adding quote " + quote.toString() + " to database.");
        t.commit();
        sess.close();
    }
}
