package com.revature.controllers;

/*
 *
 *  Configuring this controller to be compatable with stateless sessions
 *
 * 			<--SCRATCH NOTES-->
 * request.headers.get('Authorization') === 'Bearer fake-jwt-token'
 */


import com.revature.models.Quote;
import com.revature.services.AuthServiceImpl;
import com.revature.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController("/quote")
@CrossOrigin(origins = "*")
public class QuoteController {

    private static final Logger log = Logger.getLogger("QuoteController");
    private QuoteService quoteservice;

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

    @Autowired
    public void setAuthServiceImpl(AuthServiceImpl as) {
        this.as = as;
    }
}
