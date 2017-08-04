package com.andrei.jpa.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarModelPrototype;

/**
 * Repository for {@link CarModelPrototype}.
 * 
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */
public interface CarModelPrototypeRepository extends JpaRepository<CarModelPrototype, Long> {

	@Modifying
	@Query("DELETE FROM CarModelPrototype prototype WHERE prototype.carBrand = :carBrand")
	void deleteByCarBrand(@Param("carBrand") CarBrand carBrand);
}
