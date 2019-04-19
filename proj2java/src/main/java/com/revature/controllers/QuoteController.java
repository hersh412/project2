package com.revature.controllers;

import com.revature.models.Quote;
import com.revature.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController("/quote")
@CrossOrigin(origins="*")
public class QuoteController {

	private QuoteService quoteservice;
	private static final Logger log = Logger.getLogger("QuoteController");

	@PostMapping(value = "/quote/generate", consumes = "application/json")
	public ResponseEntity generateQuote(@RequestBody Quote quote) {
		log.info("*Got quote request: " + quote.toString());
		double quotePrice = quoteservice.generateQuote(quote);
		return new ResponseEntity(quotePrice, HttpStatus.OK);
	}

	@Autowired
	public void setQuoteservice(QuoteService quoteservice) {
		this.quoteservice = quoteservice;
	}
}

