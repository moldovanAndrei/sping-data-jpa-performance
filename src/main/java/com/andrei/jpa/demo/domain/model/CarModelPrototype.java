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
 * @version $Id: CarModelPrototype.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 30.07.2017
 */
@Entity
@Table(name = "CAR_MODEL_PROTOTYPE")
public class CarModelPrototype {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	@SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
	Long id;

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
	@JoinColumn(name = "CAR_MODEL_ID", nullable = false,
			foreignKey = @ForeignKey(name = "FK_CAR_MODEL_PROTOTYPE"))
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
