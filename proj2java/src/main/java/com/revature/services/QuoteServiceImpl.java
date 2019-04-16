package com.revature.services;

import com.revature.daos.QuoteDao;
import com.revature.models.Quote;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {
    private static final Logger log = LogManager.getLogger(QuoteServiceImpl.class);
    private QuoteDao qd;

    public QuoteServiceImpl() {
    }

    public QuoteServiceImpl(QuoteDao qd) {
        this.qd = qd;
    }

    @Override
    public void addQuote(Quote q) {
        qd.saveQuote(q);
    }

    @Override
    public List getAllQuotes() {
        return null;
    }

    @Autowired
    public void setQd(QuoteDao qd) {
        this.qd = qd;
    }
}
