package com.andrei.jpa.demo.examples.nplusone;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarModel;
import com.andrei.jpa.demo.domain.model.CarProject;
import com.andrei.jpa.demo.domain.repository.CarModelRepository;
import com.andrei.jpa.demo.domain.repository.CarProjectRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ${TODO} Klassenbeschreibung
 *
 * @author DVM5CLT
 * @version $Id: A_NPlusOneBeginner.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 01.08.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class A_NPlusOneBeginner {

	@Autowired
	private CarProjectRepository carProjectRepository;
	@Autowired
	private CarModelRepository carModelRepository;

	private long startTime;

	@Before
	public void setup() {
		startTime = System.currentTimeMillis();
	}

	@Test
	public void nPlusOneBeginnerUsecase() {

		List<CarProject> carProjects = carProjectRepository.findByCarBrand(CarBrand.AUDI);
		for(CarProject project : carProjects) {
			List<CarModel> projectModels = carModelRepository.findByCarProject(project);
			processCarModels(projectModels);
		}
	}

	private void processCarModels(List<CarModel> projectModels) {

		//Do something that doesn't make any sens.
		for (CarModel model : projectModels) {
			model.getModelName().compareTo(model.getDescription());
		}
	}

	@After
	public void logExectionTime() {

		long finish = System.currentTimeMillis();
		System.out.println("Execution time: " + (finish - startTime) + "ms");
	}
}
