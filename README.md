# PrimeGenerator
Spring Boot app that generates prime numbers using different algorithms

## General Information
This is a Spring Boot backend web API

## Technologies Used
- Java
- Spring Boot
- JUnit

## Features
The main features are:
- Calculate prime numbers up to a given number and using a selected algorithm
- Returns the prime numbers in JSON format

## Usage
Call the web API to get the prime numbers:

*/primes?n=x&algorithm=y*

where x is the number to generate prime numbers to and algorithm is either 1, 2 or 3 
(1 = Sieve of Eratosthenes, 2 = Java 8, 3 = Brute force)

The prime numbers are returned in JSON format:

*[2,3,5,7, ...]*

## Project Status
Project is: _complete_

## Contact
Created by [@ostenlun](https://www.codeheaven.one/) - feel free to contact me!

## License
This project is open source and available under the [MIT License]().
