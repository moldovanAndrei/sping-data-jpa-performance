package com.andrei.jpa.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.andrei.jpa.demo.util.DemoDataCreator;

/**
 * Creates DB entries for the Spring Data JPA demo.
 *
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateDemoData {

	@Autowired
	private DemoDataCreator demoDataCreator;

	@Test
	public void createTestData() {
		long time = System.currentTimeMillis();
		this.demoDataCreator.createDemoData();
		System.out.println("Created demo data in " + (System.currentTimeMillis() - time) / 1000 + "s");
	}
}
