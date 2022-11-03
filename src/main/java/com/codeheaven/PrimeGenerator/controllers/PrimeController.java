package com.codeheaven.PrimeGenerator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.NumberFormatException;
import com.codeheaven.PrimeGenerator.services.PrimeService;

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

	private enum ResponseType { JSON, XML };
	private final String JSON = "json";
	private final String XML = "xml";
	
	@Autowired
	private PrimeService primeService;

	@GetMapping("/")
	public String index() {
		return "Call /primes?n=x&algorithm=y where n = max number to generate prime numbers to and algorithm = 1, 2 or 3 (1 = Sieve of Eratosthenes, 2 = Java 8, 3 = Brute force)";
	}
	
	/**
	 * Handles requests to get prime numbers in JSON format
	 * 
	 * @param n: max number to generate prime numbers to
	 * @param algorithm: 1, 2 or 3 (1 = Sieve of Eratosthenes, 2 = Java 8, 3 = Brute force)
	 * @return
	 */
	@RequestMapping(
			value = "/primesjson", 
			method = RequestMethod.GET, 
			consumes = MediaType.ALL_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin()
	@ResponseBody
	public List<Integer> primesJson(@RequestParam String n, @RequestParam(name="algorithm", required=false) String algorithm) {
		if (primeService != null) {
			return primeService.generatePrimeNumbers(n, algorithm);
		}
		return null;
	}

	/**
	 * Handles requests to get prime numbers in XML format
	 * 
	 * @param n: max number to generate prime numbers to
	 * @param algorithm: 1, 2 or 3 (1 = Sieve of Eratosthenes, 2 = Java 8, 3 = Brute force)
	 * @return
	 */
	@RequestMapping(
			value = "/primesxml", 
			method = RequestMethod.GET, 
			consumes = MediaType.ALL_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE)
	@CrossOrigin()
	@ResponseBody
	public List<Integer> primesXml(@RequestParam String n, @RequestParam(name="algorithm", required=false) String algorithm) {
		if (primeService != null) {
			return primeService.generatePrimeNumbers(n, algorithm);
		}
		return null;
	}
}