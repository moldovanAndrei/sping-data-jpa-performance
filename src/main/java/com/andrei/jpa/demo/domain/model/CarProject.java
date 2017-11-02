package com.andrei.jpa.demo.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.andrei.jpa.demo.domain.CarBrand;
import com.sun.istack.internal.NotNull;

/**
 * {@code Entity} for a car project.
 *
 * @author Andrei Moldovan
 * @since 30.07.2017
 */
@Entity
@Table(name = "CAR_PROJECT")
@EntityListeners(AuditingEntityListener.class)
public class CarProject extends AbstractEntity {

	@NotNull
	@CreatedDate
	@Column(name = "CREATED_DATE", nullable = false)
	private LocalDateTime createdDate;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 15)
	private CarBrand carBrand;

	@NotNull
	@Column(nullable = false, length = 50)
	private String name;

	@NotNull
	@Column(nullable = false, length = 255)
	private String description;

	@OneToMany(mappedBy = "carProject", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<CarModel> carModels = new ArrayList<>();

	public CarProject() {

	}

	public CarProject(CarBrand carBrand, String name, String description) {
		this.carBrand = carBrand;
		this.name = name;
		this.description = description;
	}

	public CarBrand getCarBrand() {
		return this.carBrand;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public List<CarModel> getCarModels() {
		return this.carModels;
	}

	public void addCarModel(CarModel carModel) {
		this.carModels.add(carModel);
		carModel.setCarProject(this);
	}
}
