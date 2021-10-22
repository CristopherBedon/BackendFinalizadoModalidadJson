package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Modalidad;
import com.empresa.repository.ModalidadRepository;

@Service
public class ModalidadServiceImpl implements ModalidadService {

	@Autowired
	private ModalidadRepository repositorio;

	@Override
	public Modalidad insertaActualizaModalidad(Modalidad obj) {
		return repositorio.save(obj);
	}

	@Override
	public List<Modalidad> listaModalidad() {
		return repositorio.findAll();
	}

	@Override
	public List<Modalidad> listaModalidadNombreLike(String nombre) {
		return repositorio.findByNombreLike(nombre);
	}

	@Override
	public List<Modalidad> listaModalidadSedeLike(String sede) {
		return repositorio.findBySedeLike(sede);
	}

	@Override
	public List<Modalidad> listaModalidadNombreSede(String nombre, String sede) {
		return repositorio.listaPorNombreSede(nombre, sede);
	}

}
