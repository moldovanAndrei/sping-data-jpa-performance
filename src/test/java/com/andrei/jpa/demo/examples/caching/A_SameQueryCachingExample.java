package com.andrei.jpa.demo.examples.caching;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarProject;
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

import java.util.List;

/**
 * ${TODO} Klassenbeschreibung
 *
 * @author DVM5CLT
 * @version $Id: HibernateCascadeDelete.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 31.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
//True is the default value, but let's make it more obvious.
@Rollback(true)
public class A_SameQueryCachingExample {

	@Autowired
	private CarProjectRepository carProjectRepository;

	@Test
	public void sameQueryCachingExample() {

		long start = System.currentTimeMillis();

		carProjectRepository.findByCarBrandFetchModels(CarBrand.AUDI);
		long time = System.currentTimeMillis();
		System.out.println("First query execution time: " + (time - start) + " ms");

		carProjectRepository.findByCarBrandFetchModels(CarBrand.AUDI);
		long finish =System.currentTimeMillis();
		System.out.println("Second query execution time: " + (finish - time) + " ms");
	}
}
