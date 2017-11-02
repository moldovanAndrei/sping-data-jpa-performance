package com.andrei.jpa.demo.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.andrei.jpa.demo.domain.CarBrand;
import com.sun.istack.internal.NotNull;

/**
 * {@code Entity} for a car model property.
 *
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */
@Entity
@Table(name = "CAR_MODEL_PROPERTY")
public class CarModelProperty extends AbstractEntity {

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 15)
	private CarBrand carBrand;

	@NotNull
	@Column(nullable = false, length = 50)
	private String property;

	@NotNull
	@Column(nullable = false, length = 50)
	private String propertyFamily;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CAR_MODEL_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_CAR_MODEL_PROPERTY"))
	private CarModel carModel;

	public CarModelProperty() {
	}

	public CarModelProperty(String property, String propertyFamily, CarBrand carBrand) {
		this.property = property;
		this.propertyFamily = propertyFamily;
		this.carBrand = carBrand;
	}

	public String getProperty() {
		return this.property;
	}

	public String getPropertyFamily() {
		return this.propertyFamily;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}
}
