package com.andrei.jpa.demo.domain.service;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarModel;
import com.andrei.jpa.demo.domain.model.CarProject;
import com.andrei.jpa.demo.domain.repository.CarModelRepository;
import com.andrei.jpa.demo.domain.repository.CarProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ${TODO} Klassenbeschreibung
 *
 * @author DVM5CLT
 * @version $Id: CarProjectService.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
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

		CarProject project = carProjectRepository.findByCarBrandFetchModels(carBrand).get(0);

		List<CarModel> carModels = carModelRepository.findByCarProjectWithPageable(project, new PageRequest(0, 2));
		if (carModels.size() != 2) {
			throw new RuntimeException("Something went wrong o . O");
		}

		//to delete
		CarModel firstModel = carModels.get(0);
		String firstModelName = firstModel.getModelName();
		//to update
		CarModel secondModel = carModels.get(1);

		//create a new one.
		CarModel newCarModel = new CarModel(secondModel.getModelName(), "Some description", carBrand);
		project.addCarModel(newCarModel);

		//delete first.
		carModelRepository.delete(firstModel);

		//update second.
		secondModel.setModelName(firstModelName);
		//save the new one.
		carModelRepository.save(newCarModel);
	}
}
