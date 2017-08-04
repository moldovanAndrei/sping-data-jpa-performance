package com.andrei.jpa.demo.examples.uniqueconstraints;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.service.CarModelService;

/**
 * Unique constraint violation example when not flushing.
 *
 * @author Andrei Moldovan
 * @since 30.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class A_ViolateUniqueConstraint {

	@Autowired
	private CarModelService carModelService;

	@Test
	public void test() {
		// Live demo.
		this.carModelService.saveCarModels(CarBrand.AUDI);
	}
}
