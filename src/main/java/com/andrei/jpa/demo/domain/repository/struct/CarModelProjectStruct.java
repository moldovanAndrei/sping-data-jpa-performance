package com.andrei.jpa.demo.domain.repository.struct;

import java.io.Serializable;

/**
 * Structure object for reducing the result set.
 *
 * @author DVM5CLT
 * @version $Id: CarModelProjectStruct.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
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
		return carModelName;
	}

	public String getCarModelProject() {
		return carModelProject;
	}
}
