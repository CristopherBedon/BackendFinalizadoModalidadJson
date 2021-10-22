package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {

	/*Construcción de Querys según el nombre del método que le pongámos*/
	
	//Filtrar por el nombre del docente
	public abstract List<Docente> findByNombreLike(String filtro);
	
	//Filtrar por dni del docente
	public abstract List<Docente> findByDni(String filtro);
	
	//Filtrar por nombre y dni con JPQL
	@Query("Select e from Docente e where e.nombre like :param_nom and e.dni = :param_dni")
	public abstract List<Docente> listaPorNombreDni(@Param("param_nom") String nombre,@Param("param_dni") String dni);

	
	
	
}


