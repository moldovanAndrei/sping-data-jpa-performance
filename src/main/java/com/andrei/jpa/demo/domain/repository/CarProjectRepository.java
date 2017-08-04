package com.andrei.jpa.demo.domain.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarProject;

/**
 * Repository for {@link CarProject}.
 *
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */
public interface CarProjectRepository extends JpaRepository<CarProject, Long> {

	List<CarProject> findByCarBrand(CarBrand carBrand);

	@Query("SELECT DISTINCT carProject FROM CarProject carProject LEFT JOIN FETCH carProject.carModels WHERE carProject.carBrand = :carBrand")
	List<CarProject> findByCarBrandFetchModels(@Param("carBrand") CarBrand carBrand);

	@QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value = "1000"))
	@Query("SELECT DISTINCT carProject FROM CarProject carProject LEFT JOIN FETCH carProject.carModels WHERE carProject.carBrand = :carBrand")
	List<CarProject> findByCarBrandFetchModelsQueryHints(@Param("carBrand") CarBrand carBrand);

	@Modifying
	@Query("DELETE FROM CarProject project WHERE project.carBrand = :carBrand")
	void deleteByCarBrand(@Param("carBrand") CarBrand carBrand);
}
