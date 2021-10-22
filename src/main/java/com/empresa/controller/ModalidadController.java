package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Docente;
import com.empresa.entity.Filtro;
import com.empresa.entity.Modalidad;
import com.empresa.service.ModalidadService;
import com.empresa.util.Constantes;

@RestController
@RequestMapping("/rest/modalidad")
@CrossOrigin(origins = "http://localhost:4200")
public class ModalidadController {

	@Autowired
	private ModalidadService modalidadService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Modalidad>> listaAlumno() {
		List<Modalidad> lista = modalidadService.listaModalidad();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaModalidad(@RequestBody Modalidad obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Modalidad objSalida = modalidadService.insertaActualizaModalidad(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/porNombre/{paramNombre}")
	@ResponseBody
	public ResponseEntity<List<Modalidad>> listaPorNombre(@PathVariable("paramNombre") String filtro) {
		List<Modalidad> lista = modalidadService.listaModalidadNombreLike(filtro + "%");
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porSede/{paramSede}")
	@ResponseBody
	public ResponseEntity<List<Modalidad>> listaPorSede(@PathVariable("paramSede") String filtro) {
		List<Modalidad> lista = modalidadService.listaModalidadSedeLike(filtro + "%");
		return ResponseEntity.ok(lista);
	}
	
		//JSON
		@GetMapping(path = "/porNombreSedeJson")
		@ResponseBody
		public ResponseEntity<Map<String, Object>> listaPorNombreSedeJSON(@RequestBody Filtro obj) {
			
			Map<String, Object> salida = new HashMap<>();
			try {
				List<Modalidad> lista = modalidadService.listaModalidadNombreSede(obj.getNombre() + "%", obj.getSede() + "%");
				if(CollectionUtils.isEmpty(lista)) {
					salida.put("mensaje", "No existe Datos");
				}else {
					salida.put("lista", lista);
				}
			} catch (Exception e) {
					e.printStackTrace();
					salida.put("mensaje", "Error en la consulta " + e.getMessage());
			}
			return ResponseEntity.ok(salida);
		}
	
	
	
	
	
	

}
