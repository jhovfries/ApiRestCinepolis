package com.mx.ApiRestPeliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestPeliculas.model.Peliculas;
import com.mx.ApiRestPeliculas.service.PeliculasServImp;
@RestController
@RequestMapping(path="api/v1")
@CrossOrigin
public class PeliculasWebService {
	@Autowired
	PeliculasServImp peliculasServImp;
	
	// ****** http://localhost:9000/api/v1/mostrar
	@GetMapping(path="mostrar")
	public List<Peliculas> mostrarRegis(){
		return peliculasServImp.mostrar();
	}
	
	@PostMapping(path="guardar")
	public ResponseEntity<?> guardar(@RequestBody Peliculas pelicula){
		try {
			boolean response = peliculasServImp.guardar(pelicula);
			if(response == true)
				return new ResponseEntity<String>("No se guardo, ya existe esta pelicula", HttpStatus.OK);
			else
				return new ResponseEntity<Peliculas>(pelicula, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Error al guardar "+ e.getMessage(), HttpStatus.OK);
		}
	}
	
	@PostMapping(path="buscar")
	public ResponseEntity<?> buscar(@RequestBody Peliculas pelicula){
		Peliculas peliEncontrada = peliculasServImp.buscar(pelicula.getIdPelicula());
		
		if(peliEncontrada==null)
			return new ResponseEntity<String>("No existe pelicula", HttpStatus.OK);
		else 
			return new ResponseEntity<Peliculas>(peliEncontrada, HttpStatus.OK);
	}
	
	@PutMapping(path="editar")
	public ResponseEntity<?> editar(@RequestBody Peliculas pelicula){
		try {
			boolean response = peliculasServImp.editar(pelicula);
			if(response == false)
				return new ResponseEntity<String>("No existe pelicula", HttpStatus.OK);
			else
				return new ResponseEntity<Peliculas>(pelicula, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Error al editar "+ e.getMessage(), HttpStatus.OK);
		}
	}
	
	
	@PostMapping(path="eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Peliculas pelicula){
		try {
			boolean response = peliculasServImp.eliminar(pelicula.getIdPelicula());
			if(response == false)
				return new ResponseEntity<String>("No existe pelicula", HttpStatus.OK);
			else
				return new ResponseEntity<String>("Pelicula eliminada", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Error al eliminar "+ e.getMessage(), HttpStatus.OK);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
