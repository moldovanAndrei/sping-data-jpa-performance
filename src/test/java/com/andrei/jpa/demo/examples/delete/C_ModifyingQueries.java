package com.andrei.jpa.demo.examples.delete;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.repository.CarModelPropertyRepository;
import com.andrei.jpa.demo.domain.repository.CarModelPrototypeRepository;
import com.andrei.jpa.demo.domain.repository.CarModelRepository;
import com.andrei.jpa.demo.domain.repository.CarProjectRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${TODO} Klassenbeschreibung
 *
 * @author DVM5CLT
 * @version $Id: ModifyingQueries.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 31.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
//True is the default value, but let's make it more obvious.
@Rollback(true)
public class C_ModifyingQueries {

	@Autowired
	private CarProjectRepository carProjectRepository;
	@Autowired
	private CarModelRepository carModelRepository;
	@Autowired
	private CarModelPrototypeRepository carModelPrototypeRepository;
	@Autowired
	private CarModelPropertyRepository carModelPropertyRepository;

	private long startTime;

	@Before
	public void setup() {
		startTime = System.currentTimeMillis();
	}

	@Test
	public void hibernateCascadeDeleteExample() {

		carModelPropertyRepository.deleteByCarBrand(CarBrand.AUDI);
		carModelPrototypeRepository.deleteByCarBrand(CarBrand.AUDI);
		carModelRepository.deleteByCarBrand(CarBrand.AUDI);
		carProjectRepository.deleteByCarBrand(CarBrand.AUDI);

		carProjectRepository.flush();
	}

	@After
	public void logExectionTime() {

		long finish = System.currentTimeMillis();
		System.out.println("Execution time: " + (finish - startTime) + "ms");
	}
}
