package com.revature.controllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Quote;
import com.revature.services.QuoteService;

@RestController("/quote")
@CrossOrigin(origins="*")
public class QuoteController {

    private QuoteService quoteservice;
	private static final Logger log = Logger.getLogger("QuoteController");

	
	@PostMapping(value="/quote/generate", consumes="application/json")
	public ResponseEntity generateQuote(@RequestBody Quote quote, HttpSession sess)  {
		System.out.println(quote);
        quoteservice.addQuote(quote);
		System.out.println("*********");
		System.out.println(quote);
		return new ResponseEntity("{\"price\" : \"$1500\"}", HttpStatus.OK);
	}

	@Autowired
	public void setQuoteservice(QuoteService quoteservice) {
		this.quoteservice = quoteservice;
	}


	
	
	
}