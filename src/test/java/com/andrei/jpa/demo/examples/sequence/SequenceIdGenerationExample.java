/*
 * spring-data-jpa-demo:SequenceIdGenerationExample.java
 * (c) Copyright minnosphere GmbH 2017
 */
package com.andrei.jpa.demo.examples.sequence;

import javax.persistence.SequenceGenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarProject;
import com.andrei.jpa.demo.domain.repository.CarProjectRepository;

/**
 * Example showcase for jdbc_batching and {@link SequenceGenerator}
 * allocationSize.
 * 
 * @author Andrei Moldovan
 * @version 1.0
 * @since 02.11.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class SequenceIdGenerationExample {

	@Autowired
	private CarProjectRepository carProjectRepository;

	/**
	 * Reminder: play with application.properties batch_size (1,10,50,100) and
	 * with sequence allocation/increment. (1,10,100,1000)
	 */
	@Test
	public void generateCarProjects() {

		long time = System.currentTimeMillis();
		for (int i = 1; i < 50000; i++) {
			CarProject carProject = new CarProject(CarBrand.VOLKSWAGEN, "name" + i, "description" + i);
			this.carProjectRepository.save(carProject);
		}

		long timeAfterCreate = System.currentTimeMillis();
		System.out.println("Generated car projects in " + (timeAfterCreate - (double) time) / 1000 + "s");

		this.carProjectRepository.flush();
		System.out.println("Flushed repo in " + (System.currentTimeMillis() - (double) timeAfterCreate) / 1000 + "s");
	}
}
