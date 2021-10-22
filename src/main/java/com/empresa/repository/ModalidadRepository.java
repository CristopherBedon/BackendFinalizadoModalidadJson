package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>  {

	public abstract List<Modalidad> findByNombreLike(String nombre); 
	
	public abstract List<Modalidad> findBySedeLike(String sede);
	
	@Query("Select m from Modalidad m where m.nombre like :param_nombre and m.sede like :param_sede")
	public abstract List<Modalidad> listaPorNombreSede (@Param("param_nombre") String nombre,
														@Param("param_sede") String sede);
	
}
