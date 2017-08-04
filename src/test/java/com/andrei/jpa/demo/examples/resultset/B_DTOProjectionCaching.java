package com.andrei.jpa.demo.examples.resultset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.repository.CarModelRepository;

/**
 * Caching works for DTO projection too.
 *
 * @author Andrei Moldovan
 * @since 30.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class B_DTOProjectionCaching {

	@Autowired
	private CarModelRepository carModelRepository;

	@Test
	public void sameQueryCachingExample() {

		long start = System.currentTimeMillis();

		this.carModelRepository.findByCarBrandAsStruct(CarBrand.AUDI);
		long time = System.currentTimeMillis();
		System.out.println("First query execution time: " + (time - start) + " ms");

		this.carModelRepository.findByCarBrandAsStruct(CarBrand.AUDI);
		long finish = System.currentTimeMillis();
		System.out.println("Second query execution time: " + (finish - time) + " ms");
	}
}
