package com.revature.services;

import java.util.List;

import com.revature.models.Quote;

public interface QuoteService {

    void addQuote(Quote q);

    List getAllQuotes();

}
