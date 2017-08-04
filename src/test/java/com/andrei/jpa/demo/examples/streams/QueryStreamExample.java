package com.andrei.jpa.demo.examples.streams;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarModel;
import com.andrei.jpa.demo.domain.repository.CarModelRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ${TODO} Klassenbeschreibung
 *
 * @author DVM5CLT
 * @since 31.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class QueryStreamExample {

	@Autowired
	private CarModelRepository carModelRepository;

	private long startTime;

	@Before
	public void setup() {
		startTime = System.currentTimeMillis();
	}

	@Test
	public void test() throws Exception {
		try (
				Stream<CarModel> audiCars = carModelRepository.findByCarBrandAsStream(CarBrand.AUDI);
				Stream<CarModel> volkswagenCars = carModelRepository.findByCarBrandAsStream(CarBrand.VOLKSWAGEN)
		) {
			Stream.concat(processAudiCars(audiCars), processVolkswagenCars(volkswagenCars))
					.collect(Collectors.toList());
		}
	}

	private Stream<CarModel> processAudiCars(Stream<CarModel> audiCars) {
		return audiCars.filter(car -> car.getModelName().contains("1"));
	}

	private Stream<CarModel> processVolkswagenCars(Stream<CarModel> volkswagenCars) {
		return volkswagenCars.filter(car -> car.getModelName().contains("2"));
	}

	@After
	public void logExectionTime() {

		long finish = System.currentTimeMillis();
		System.out.println("Execution time: " + (finish - startTime) + "ms");
	}
}
