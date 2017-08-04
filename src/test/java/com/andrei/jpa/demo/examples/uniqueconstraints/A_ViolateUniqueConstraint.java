package com.andrei.jpa.demo.examples.uniqueconstraints;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.service.CarModelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ${TODO} Klassenbeschreibung
 *
 * @author DVM5CLT
 * @version $Id: A_ViolateUniqueConstraint.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 31.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class A_ViolateUniqueConstraint {

	@Autowired
	private CarModelService carModelService;

	@Test
	public void test() {
		//Live demo.
		carModelService.saveCarModels(CarBrand.AUDI);
	}
}
