package com.andrei.jpa.demo.domain.repository.struct;

import java.io.Serializable;

/**
 * Structure object for reducing the result set.
 * 
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */
public class CarModelProjectStruct implements Serializable {

	private static final long serialVersionUID = -4584626412036180901L;

	private String carModelName;
	private String carModelProject;

	public CarModelProjectStruct(String carModelName, String carModelProject) {
		this.carModelName = carModelName;
		this.carModelProject = carModelProject;
	}

	public String getCarModelName() {
		return this.carModelName;
	}

	public String getCarModelProject() {
		return this.carModelProject;
	}
}
