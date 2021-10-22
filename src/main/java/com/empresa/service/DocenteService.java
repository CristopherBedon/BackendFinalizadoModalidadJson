package com.empresa.service;

import java.util.List;

import com.empresa.entity.Docente;

public interface DocenteService {

	public abstract List<Docente> listaDocente();

	public abstract Docente insertaActualizaDocente(Docente obj);
	
	public abstract List<Docente> listaDocentePorNombreLike(String filtro);
	
	public abstract List<Docente> listaDocentePorDni(String filtro); 

	public abstract List<Docente> listaDocentePorNombreDni(String nombre, String dni);
}
