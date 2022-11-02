package com.codeheaven.PrimeGenerator.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.codeheaven.PrimeGenerator.services.PrimeService;

/**
 * Test class for PrimeService class
 * 
 * @author Olli Stenlund
 */
@SpringBootTest
class PrimeServiceTest {
	private PrimeService primeService = new PrimeService();

    @Test
    public void testSieveOfEratosthenes() {
    	ArrayList<Integer> listAnswer = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7));
    	List<Integer> listActual = primeService.sieveOfEratosthenes(10);
    	Assertions.assertIterableEquals(listAnswer, listActual);
    }

    @Test
    public void testJava8() {
    	ArrayList<Integer> listAnswer = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7));
    	List<Integer> listActual = primeService.primeNumbersTill(10);
    	Assertions.assertIterableEquals(listAnswer, listActual);
    }

    @Test
    public void testBruteForce() {
    	ArrayList<Integer> listAnswer = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7));
    	List<Integer> listActual = primeService.primeNumbersBruteForce(10);
    	Assertions.assertIterableEquals(listAnswer, listActual);
    }
}
