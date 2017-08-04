package com.andrei.jpa.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarModel;
import com.andrei.jpa.demo.domain.model.CarProject;
import com.andrei.jpa.demo.domain.repository.CarModelRepository;
import com.andrei.jpa.demo.domain.repository.CarProjectRepository;

/**
 * Service implementation for car models.
 *
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */
@Service
public class CarModelService {

	@Autowired
	private CarProjectRepository carProjectRepository;
	@Autowired
	private CarModelRepository carModelRepository;

	@Transactional
	public void saveCarModels(CarBrand carBrand) {

		CarProject project = this.carProjectRepository.findByCarBrandFetchModels(carBrand).get(0);

		List<CarModel> carModels = this.carModelRepository.findByCarProjectWithPageable(project, new PageRequest(0, 2));
		if (carModels.size() != 2) {
			throw new RuntimeException("Something went wrong o . O");
		}

		// to delete
		CarModel firstModel = carModels.get(0);
		String firstModelName = firstModel.getModelName();
		// to update
		CarModel secondModel = carModels.get(1);

		// create a new one.
		CarModel newCarModel = new CarModel(secondModel.getModelName(), "Some description", carBrand);
		project.addCarModel(newCarModel);

		// delete first.
		this.carModelRepository.delete(firstModel);
		// carModelRepository.flush();

		// update second.
		secondModel.setModelName(firstModelName);
		// carModelRepository.flush();

		// save the new one.
		this.carModelRepository.save(newCarModel);
	}
}
