package com.andrei.jpa.demo.examples.resultset;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.repository.CarModelRepository;
import com.andrei.jpa.demo.domain.repository.struct.CarModelProjectStruct;

/**
 * Using DTO projection to reduce the result set.
 *
 * @author Andrei Moldovan
 * @since 30.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class A_ReducingResultSet {

	@Autowired
	private CarModelRepository carModelRepository;

	private long startTime;

	@Before
	public void setup() {
		this.startTime = System.currentTimeMillis();
	}

	@Test
	public void usingStructsToReduceResultSet() {
		List<CarModelProjectStruct> carModels = this.carModelRepository.findByCarBrandAsStruct(CarBrand.AUDI);
		System.out.println("Found " + carModels.size() + " car model structs.");
		processCarModels(carModels);
	}

	private void processCarModels(List<CarModelProjectStruct> models) {

		// Do something that doesn't make any sens.
		for (CarModelProjectStruct model : models) {
			model.getCarModelName().compareTo(model.getCarModelProject());
		}
	}

	@After
	public void logExectionTime() {

		long finish = System.currentTimeMillis();
		System.out.println("Execution time: " + (finish - this.startTime) + "ms");
	}
}
