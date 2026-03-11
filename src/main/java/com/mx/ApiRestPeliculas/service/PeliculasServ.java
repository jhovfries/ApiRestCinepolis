package com.mx.ApiRestPeliculas.service;

import java.util.List;

import com.mx.ApiRestPeliculas.model.Peliculas;



public interface PeliculasServ {
	public List<Peliculas> mostrar();
	
	public boolean guardar(Peliculas pelicula);
	
	public Peliculas buscar(Integer idPelicula);
	
	public boolean editar(Peliculas pelicula);
	
	public boolean eliminar(Integer idPeli);

}
