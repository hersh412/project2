package com.revature.controllers;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.QuoteService;

@RestController("/quote")
@CrossOrigin(origins="*")
public class QuoteController {
	
	private QuoteService  quoteservice;
	private static final Logger log = Logger.getLogger("QuoteController");
	
	
	
	

}
