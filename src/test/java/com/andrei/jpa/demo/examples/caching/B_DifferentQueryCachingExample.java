package com.andrei.jpa.demo.examples.caching;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.repository.CarModelRepository;
import com.andrei.jpa.demo.domain.repository.CarProjectRepository;

/**
 * Second example for query caching.
 *
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
// True is the default value, but let's make it more obvious.
@Rollback(true)
public class B_DifferentQueryCachingExample {

	@Autowired
	private CarProjectRepository carProjectRepository;
	@Autowired
	private CarModelRepository carModelRepository;

	@Test
	public void differentQueryCachingExample() {

		this.carProjectRepository.findByCarBrandFetchModels(CarBrand.AUDI);

		long start = System.currentTimeMillis();
		this.carModelRepository.findByCarBrand(CarBrand.AUDI);
		long finish = System.currentTimeMillis();

		System.out.println("Execution time of loading car models: " + (finish - start) + "ms");
	}
}
