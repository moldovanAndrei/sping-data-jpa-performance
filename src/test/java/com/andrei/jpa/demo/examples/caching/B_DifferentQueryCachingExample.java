package com.andrei.jpa.demo.examples.caching;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.repository.CarModelRepository;
import com.andrei.jpa.demo.domain.repository.CarProjectRepository;
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
 * @version $Id: EntityCachingExample.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 31.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
//True is the default value, but let's make it more obvious.
@Rollback(true)
public class B_DifferentQueryCachingExample {

	@Autowired
	private CarProjectRepository carProjectRepository;
	@Autowired
	private CarModelRepository carModelRepository;

	@Test
	public void differentQueryCachingExample() {

		carProjectRepository.findByCarBrandFetchModels(CarBrand.AUDI);

		long start = System.currentTimeMillis();
		carModelRepository.findByCarBrand(CarBrand.AUDI);
		long finish = System.currentTimeMillis();

		System.out.println("Execution time of loading car models: " + (finish - start) + "ms");
	}
}
