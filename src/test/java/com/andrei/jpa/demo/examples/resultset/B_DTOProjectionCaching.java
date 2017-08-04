package com.andrei.jpa.demo.examples.resultset;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.repository.CarModelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${TODO} Klassenbeschreibung
 *
 * @author DVM5CLT
 * @version $Id: B_DTOProjectionCaching.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 31.07.2017
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

		carModelRepository.findByCarBrandAsStruct(CarBrand.AUDI);
		long time = System.currentTimeMillis();
		System.out.println("First query execution time: " + (time - start) + " ms");

		carModelRepository.findByCarBrandAsStruct(CarBrand.AUDI);
		long finish = System.currentTimeMillis();
		System.out.println("Second query execution time: " + (finish - time) + " ms");
	}
}
