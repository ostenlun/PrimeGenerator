package com.codeheaven.PrimeGenerator.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import com.codeheaven.PrimeGenerator.controllers.PrimeController;

public class PrimeGeneratorAppTests {
	@Autowired
	private PrimeController primeController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(primeController).isNotNull();
	}
}

