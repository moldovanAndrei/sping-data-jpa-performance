package com.andrei.jpa.demo.domain.model;

import com.andrei.jpa.demo.domain.CarBrand;
import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * ${TODO} Klassenbeschreibung
 *
 * @author DVM5CLT
 * @version $Id: CarModelProperty.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 30.07.2017
 */
@Entity
@Table(name = "CAR_MODEL_PROPERTY")
public class CarModelProperty {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	@SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
	Long id;

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
	@JoinColumn(name = "CAR_MODEL_ID", nullable = false,
			foreignKey = @ForeignKey(name = "FK_CAR_MODEL_PROPERTY"))
	private CarModel carModel;

	public CarModelProperty() {
	}

	public CarModelProperty(String property, String propertyFamily, CarBrand carBrand) {
		this.property = property;
		this.propertyFamily = propertyFamily;
		this.carBrand = carBrand;
	}

	public String getProperty() {
		return property;
	}

	public String getPropertyFamily() {
		return propertyFamily;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}
}
