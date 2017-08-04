package com.andrei.jpa.demo.examples.caching;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.repository.CarProjectRepository;

/**
 * Query caching example.
 *
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
// True is the default value, but let's make it more obvious.
@Rollback(true)
public class A_SameQueryCachingExample {

	@Autowired
	private CarProjectRepository carProjectRepository;

	@Test
	public void sameQueryCachingExample() {

		long start = System.currentTimeMillis();

		this.carProjectRepository.findByCarBrandFetchModels(CarBrand.AUDI);
		long time = System.currentTimeMillis();
		System.out.println("First query execution time: " + (time - start) + " ms");

		this.carProjectRepository.findByCarBrandFetchModels(CarBrand.AUDI);
		long finish = System.currentTimeMillis();
		System.out.println("Second query execution time: " + (finish - time) + " ms");
	}
}
