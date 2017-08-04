package com.andrei.jpa.demo.util;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarModel;
import com.andrei.jpa.demo.domain.model.CarModelProperty;
import com.andrei.jpa.demo.domain.model.CarModelPrototype;
import com.andrei.jpa.demo.domain.model.CarProject;
import com.andrei.jpa.demo.domain.repository.CarModelPropertyRepository;
import com.andrei.jpa.demo.domain.repository.CarModelPrototypeRepository;
import com.andrei.jpa.demo.domain.repository.CarModelRepository;
import com.andrei.jpa.demo.domain.repository.CarProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Data Creator for the Spring Data JPA presentation.
 *
 * @author DVM5CLT
 * @version $Id: DemoDataCreator.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 30.07.2017
 */
@Component
public class DemoDataCreator {

	@Autowired
	private CarProjectRepository carProjectRepository;
	@Autowired
	private CarModelRepository carModelRepository;
	@Autowired
	private CarModelPropertyRepository carModelPropertyRepository;
	@Autowired
	private CarModelPrototypeRepository carModelPrototypeRepository;

	public void createDemoData() {

		deleteExistingData();
		//For every car brand
		for (CarBrand carBrand : CarBrand.values()) {
			System.out.println("Creating data for " + carBrand);
			//create 100 car projects
			for (int i = 0; i < 100; i++) {
				CarProject project = new CarProject(carBrand, carBrand + " project " + i,
						"Car project description " + i);
				carProjectRepository.save(project);
				//with 50 car models each
				for (int j = 0; j < 50; j++) {

					CarModel model = new CarModel(carBrand + " model " + j, "Car model description " + j, carBrand);
					project.addCarModel(model);
					carModelRepository.save(model);

					//each model has 10 prototypes and 10 properties.
					for (int k = 0; k < 10; k++) {
						CarModelProperty property = new CarModelProperty("Property" + k, "Family " + j, carBrand);
						CarModelPrototype prototype = new CarModelPrototype(Integer.valueOf(k),
								"Prototype description " + k, Boolean.FALSE, carBrand);
						model.addCarModelProperty(property);
						model.addCarModelPrototype(prototype);
					}
					carModelPropertyRepository.save(model.getCarModelProperties());
					carModelPrototypeRepository.save(model.getCarModelPrototypes());

				}
				carModelRepository.save(project.getCarModels());
			}
		}
	}

	private void deleteExistingData() {
		carModelPrototypeRepository.deleteAllInBatch();
		carModelPropertyRepository.deleteAllInBatch();
		carModelRepository.deleteAllInBatch();
		carProjectRepository.deleteAllInBatch();
	}
}
