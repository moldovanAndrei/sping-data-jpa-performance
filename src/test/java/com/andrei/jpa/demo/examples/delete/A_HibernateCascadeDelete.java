package com.andrei.jpa.demo.examples.delete;

import java.util.List;

import org.junit.After;
import org.junit.Before;
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
 * Hibernate cascade delete example.
 *
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
// True is the default value, but let's make it more obvious.
@Rollback(true)
public class A_HibernateCascadeDelete {

	@Autowired
	private CarProjectRepository carProjectRepository;

	private long startTime;

	@Before
	public void setup() {
		this.startTime = System.currentTimeMillis();
	}

	@Test
	public void hibernateCascadeDeleteExample() {
		List<CarProject> audiProjects = this.carProjectRepository.findByCarBrand(CarBrand.AUDI);
		this.carProjectRepository.delete(audiProjects);
		this.carProjectRepository.flush();
	}

	@After
	public void logExectionTime() {

		long finish = System.currentTimeMillis();
		System.out.println("Execution time: " + (finish - this.startTime) + "ms");
	}
}
