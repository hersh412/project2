package com.revature.services;

import com.revature.models.Quote;

import java.util.List;

public interface QuoteService {


    void addQuote(Quote q);
    Double generateQuote(Quote q);
    List getAllQuotes();
	

}
