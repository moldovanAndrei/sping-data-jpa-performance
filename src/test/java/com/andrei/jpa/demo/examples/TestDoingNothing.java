package com.andrei.jpa.demo.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * A JUnit Test that does nothing.
 *
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestDoingNothing {

	private long startTime;

	@Before
	public void setup() {
		this.startTime = System.currentTimeMillis();
	}

	@Test
	public void doNothing() {
		System.out.println("Not doing anything useful");
	}

	@After
	public void logExectionTime() {

		long finish = System.currentTimeMillis();
		System.out.println("Execution time: " + (finish - this.startTime) + "ms");
	}
}
