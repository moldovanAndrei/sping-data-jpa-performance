/*
 * spring-data-jpa-demo:AbstractEntity.java
 * (c) Copyright minnosphere GmbH 2017
 */
package com.andrei.jpa.demo.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

/**
 * Abstract entity to be used as a superclass for every {@link Entity}.
 * 
 * @author Andrei Moldovan.
 * @version 1.0
 * @since 02.11.2017
 */
@MappedSuperclass
public class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEMO_SEQ")
	@SequenceGenerator(sequenceName = "JPA_DEMO_SEQ", initialValue = 1, allocationSize = 100, name = "DEMO_SEQ")
	Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
