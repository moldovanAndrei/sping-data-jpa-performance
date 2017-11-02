package com.andrei.jpa.demo.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.andrei.jpa.demo.domain.CarBrand;
import com.sun.istack.internal.NotNull;

/**
 * {@code Entity} for a car model.
 *
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */
@Entity
@Table(name = "CAR_MODEL", uniqueConstraints = {
		@UniqueConstraint(name = "UC_CAR_PROJECT_MODELL_NAME", columnNames = { "CAR_PROJECT_ID", "MODEL_NAME" }) })
public class CarModel extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	@SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
	Long id;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 15)
	private CarBrand carBrand;

	@NotNull
	@Column(name = "MODEL_NAME", nullable = false, length = 50)
	private String modelName;

	@Column(length = 255)
	private String description;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CAR_PROJECT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_CAR_PROJECT_CAR_MODELL"))
	private CarProject carProject;

	@OneToMany(mappedBy = "carModel", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<CarModelPrototype> carModelPrototypes = new ArrayList<>();

	@OneToMany(mappedBy = "carModel", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<CarModelProperty> carModelProperties = new ArrayList<>();

	public CarModel() {
	}

	public CarModel(String modelName, String description, CarBrand carBrand) {
		this.modelName = modelName;
		this.description = description;
		this.carBrand = carBrand;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setCarProject(CarProject carProject) {
		this.carProject = carProject;
	}

	public List<CarModelPrototype> getCarModelPrototypes() {
		return this.carModelPrototypes;
	}

	public List<CarModelProperty> getCarModelProperties() {
		return this.carModelProperties;
	}

	public void addCarModelPrototype(CarModelPrototype prototype) {
		this.carModelPrototypes.add(prototype);
		prototype.setCarModel(this);
	}

	public void addCarModelProperty(CarModelProperty carModelProperty) {
		this.carModelProperties.add(carModelProperty);
		carModelProperty.setCarModel(this);
	}
}
