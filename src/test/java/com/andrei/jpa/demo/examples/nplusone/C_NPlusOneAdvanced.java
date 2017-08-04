package com.andrei.jpa.demo.examples.nplusone;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarModel;
import com.andrei.jpa.demo.domain.model.CarProject;
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
 * Example showcase 3 for the n + 1 problem.
 *
 * @author Andrei Moldovan
 * @since 30.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class C_NPlusOneAdvanced {

	@Autowired
	private CarProjectRepository carProjectRepository;

	private long startTime;

	@Before
	public void setup() {
		startTime = System.currentTimeMillis();
	}

	@Test
	public void nPlusOneAdvancedUsecase() {

		List<CarProject> audiProjects = carProjectRepository.findByCarBrandFetchModels(CarBrand.AUDI);
		System.out.println("Found " + audiProjects.size() + " projects");
		for(CarProject audiProject : audiProjects) {
			List<CarModel> projectModels = audiProject.getCarModels();
			processCarModels(projectModels);
			//Do something with your car models.
		}
	}

	private void processCarModels(List<CarModel> projectModels) {

		//Do something that doesn't make any sens.
		for(CarModel model : projectModels) {
			model.getModelName().compareTo(model.getDescription());
		}
	}

	@After
	public void logExectionTime() {

		long finish = System.currentTimeMillis();
		System.out.println("Execution time: " + (finish - startTime) + "ms");
	}
}
