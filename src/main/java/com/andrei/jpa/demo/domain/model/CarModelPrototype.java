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
 * {@code Entity} for a car model prototype.
 *
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */
@Entity
@Table(name = "CAR_MODEL_PROTOTYPE")
public class CarModelPrototype extends AbstractEntity {

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 15)
	private CarBrand carBrand;

	@NotNull
	@Column(nullable = false)
	private Integer version;

	@Column(length = 255)
	private String description;

	@NotNull
	@Column(nullable = false)
	private Boolean productionReady = Boolean.FALSE;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CAR_MODEL_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_CAR_MODEL_PROTOTYPE"))
	private CarModel carModel;

	public CarModelPrototype() {

	}

	public CarModelPrototype(Integer version, String description, Boolean productionReady, CarBrand carBrand) {
		this.version = version;
		this.description = description;
		this.productionReady = productionReady;
		this.carBrand = carBrand;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}
}
