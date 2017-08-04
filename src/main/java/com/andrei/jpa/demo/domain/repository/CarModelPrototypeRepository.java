package com.andrei.jpa.demo.domain.repository;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarModelPrototype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * ${TODO} Klassenbeschreibung
 *
 * @author DVM5CLT
 * @version $Id: CarModelPrototypeRepository.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 30.07.2017
 */
public interface CarModelPrototypeRepository extends JpaRepository<CarModelPrototype, Long> {

	@Modifying
	@Query("DELETE FROM CarModelPrototype prototype WHERE prototype.carBrand = :carBrand")
	void deleteByCarBrand(@Param("carBrand") CarBrand carBrand);
}
