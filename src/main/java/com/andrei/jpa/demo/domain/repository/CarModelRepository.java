package com.andrei.jpa.demo.domain.repository;

import com.andrei.jpa.demo.domain.CarBrand;
import com.andrei.jpa.demo.domain.model.CarModel;
import com.andrei.jpa.demo.domain.model.CarProject;
import com.andrei.jpa.demo.domain.repository.struct.CarModelProjectStruct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.stream.Stream;

/**
 * ${TODO} Klassenbeschreibung
 *
 * @author DVM5CLT
 * @version $Id: CarModelRepository.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 30.07.2017
 */
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

	List<CarModel> findByCarProject(CarProject carProject);

	@QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value = "1000"))
	@Query("SELECT new com.andrei.jpa.demo.domain.repository.struct.CarModelProjectStruct(model.modelName, model.carProject.name)"
			+ "FROM CarModel model WHERE model.carProject.carBrand = :carBrand")
	List<CarModelProjectStruct> findByCarBrandAsStruct(@Param("carBrand") CarBrand carBrand);

	@Query("FROM CarModel model WHERE model.carProject.carBrand = :carBrand")
	List<CarModel> findByCarBrand(@Param("carBrand") CarBrand carBrand);

	@Query("FROM CarModel model WHERE model.carProject = :carProject")
	List<CarModel> findByCarProjectWithPageable(@Param("carProject") CarProject carProject, Pageable pageRequest);

	@QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value = "1000"))
	@Query("SELECT DISTINCT model FROM CarModel model "
			+ "LEFT JOIN FETCH model.carModelProperties "
			+ "WHERE model.carProject.carBrand = :carBrand")
	List<CarModel> findByCarBrandFetchProperties(@Param("carBrand") CarBrand carBrand);

	@QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value = "1000"))
	@Query("SELECT DISTINCT model FROM CarModel model "
			+ "LEFT JOIN FETCH model.carModelPrototypes "
			+ "WHERE model.carProject.carBrand = :carBrand")
	List<CarModel> findByCarBrandFetchPrototypes(@Param("carBrand") CarBrand carBrand);

	@Modifying
	@Query("DELETE FROM CarModel model WHERE model.carBrand = :carBrand")
	void deleteByCarBrand(@Param("carBrand") CarBrand carBrand);

	@Query("FROM CarModel model WHERE model.carProject.carBrand = :carBrand")
	Stream<CarModel> findByCarBrandAsStream(@Param("carBrand") CarBrand audi);

}
