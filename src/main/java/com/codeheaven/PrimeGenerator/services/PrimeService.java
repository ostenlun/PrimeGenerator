package com.codeheaven.PrimeGenerator.services;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

/**
 * PrimeService class implements prime generator functions with different variations.
 * 
 * @author Olli Stenlund
 */
@Service
public class PrimeService {

	/**
	 * Generates prime numbers up to the given number n with Sieve of Eratosthenes algorithm
	 * 
	 * @param n max number to generate prime numbers to
	 * @return list of the prime numbers
	 */
    public List<Integer> sieveOfEratosthenes(int n) {
        final boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        final List<Integer> primes = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                primes.add(i);
        }
        return primes;
    }
    
	/**
	 * Generates prime numbers up to the given number n with brute force algorithm
	 * 
	 * @param n max number to generate prime numbers to
	 * @return list of the prime numbers
	 */
    public List<Integer> primeNumbersBruteForce(int max) {
        final List<Integer> primeNumbers = new LinkedList<Integer>();
        for (int i = 2; i <= max; i++) {
            if (isPrimeBruteForce(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    private boolean isPrimeBruteForce(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Generates prime numbers up to the given number n with Java 8 algorithm
	 * 
	 * @param n max number to generate prime numbers to
	 * @return list of the prime numbers
	 */
    public List<Integer> primeNumbersTill(int max) {
        return IntStream.rangeClosed(2, max)
            .filter(x -> isPrime(x))
            .boxed()
            .collect(Collectors.toList());
    }

    private boolean isPrime(int x) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(x)))
            .allMatch(n -> x % n != 0);
    }
}