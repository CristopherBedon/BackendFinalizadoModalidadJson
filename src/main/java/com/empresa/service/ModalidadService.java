package com.empresa.service;

import java.util.List;

import com.empresa.entity.Modalidad;

public interface ModalidadService {

	public Modalidad insertaActualizaModalidad(Modalidad obj);
	
	public List<Modalidad> listaModalidad();
	
	public List<Modalidad> listaModalidadNombreLike(String nombre);
	
	public List<Modalidad> listaModalidadSedeLike(String sede);
	
	public List<Modalidad> listaModalidadNombreSede(String nombre, String sede);
	
}
