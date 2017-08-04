package com.andrei.jpa.demo.examples.streams;

import java.util.List;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarModel;
import com.andrei.jpa.demo.domain.repository.CarModelRepository;

/**
 * Querying data as {@code List} result.
 *
 * @author Andrei Moldovan
 * @since 30.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class NormalExample {

	@Autowired
	private CarModelRepository carModelRepository;

	private long startTime;

	@Before
	public void setup() {
		this.startTime = System.currentTimeMillis();
	}

	@Test
	public void test() throws Exception {

		List<CarModel> audiCars = this.carModelRepository.findByCarBrand(CarBrand.AUDI);
		List<CarModel> volkswagenCars = this.carModelRepository.findByCarBrand(CarBrand.AUDI);

		Stream.concat(processAudiCars(audiCars), processVolkswagenCars(volkswagenCars));
	}

	private Stream<CarModel> processAudiCars(List<CarModel> audiCars) {
		return audiCars.stream().filter(car -> car.getModelName().contains("1"));
	}

	private Stream<CarModel> processVolkswagenCars(List<CarModel> volkswagenCars) {
		return volkswagenCars.stream().filter(car -> car.getModelName().contains("2"));
	}

	@After
	public void logExectionTime() {

		long finish = System.currentTimeMillis();
		System.out.println("Execution time: " + (finish - this.startTime) + "ms");
	}
}
