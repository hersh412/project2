package com.revature.controllers;

import com.revature.models.Quote;
import com.revature.services.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@RestController("/quote")
@CrossOrigin(origins="*")
public class QuoteController {

    private QuoteService quoteservice;
	private static final Logger log = Logger.getLogger("QuoteController");

	
	@PostMapping(value="/quote/generate", consumes="application/json")
	public ResponseEntity generateQuote(@RequestBody Quote quote, HttpSession sess)  {
        //quoteservice.addQuote(quote);
		System.out.println("*********");
		System.out.println(quote);
		return new ResponseEntity("{\"price\" : \"$1500\"}", HttpStatus.OK);
	}
}