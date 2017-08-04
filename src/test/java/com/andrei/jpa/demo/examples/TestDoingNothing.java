package com.andrei.jpa.demo.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${TODO} Klassenbeschreibung
 *
 * @author DVM5CLT
 * @version $Id: TestDoingNothing.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 31.07.2017
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestDoingNothing {

	private long startTime;

	@Before
	public void setup() {
		startTime = System.currentTimeMillis();
	}

	@Test
	public void doNothing() {
		System.out.println("Not doing anything useful");
	}

	@After
	public void logExectionTime() {

		long finish = System.currentTimeMillis();
		System.out.println("Execution time: " + (finish - startTime) + "ms");
	}
}
