package com.codeheaven.PrimeGenerator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.NumberFormatException;
import com.codeheaven.PrimeGenerator.services.*;

/**
 * PrimeController handles the REST API calls for generating prime numbers.
 * 
 * @author Olli Stenlund
 *
 */
@RestController
@RequestMapping("/")
public class PrimeController {
	private static final Logger Log = LoggerFactory.getLogger(PrimeController.class);

	@Autowired
	private PrimeService primeService;

	@GetMapping("/")
	public String index() {
		return "Call /primes?n=x&algorithm=y where n = max number to generate prime numbers to and algorithm = 1, 2 or 3 (1 = Sieve of Eratosthenes, 2 = Java 8, 3 = Brute force)";
	}
	
	// Retrieves all primes up to the given parameter
	@GetMapping("/primes")
	@CrossOrigin()
	public List<Integer> primes(@RequestParam String n, @RequestParam String algorithm) {
		if (primeService != null) {
			if (algorithm.equals("1")) {
				return primeService.sieveOfEratosthenes(Integer.parseInt(n));
			} else if (algorithm.equals("2")) {
				return primeService.primeNumbersTill(Integer.parseInt(n));
			} else if (algorithm.equals("3")) {
				return primeService.primeNumbersBruteForce(Integer.parseInt(n));
			} 
		}
		return null;
	}
	
	@GetMapping("/error")
	@CrossOrigin()
	public String error() {
		return "Error";
	}
}