package com.mx.ApiRestPeliculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestPeliculas.dao.PeliculasDao;
import com.mx.ApiRestPeliculas.model.Peliculas;

@Service
public class PeliculasServImp implements PeliculasServ{
	@Autowired
	PeliculasDao peliculasDao;
	
	
	@Transactional(readOnly = true)
	@Override
	public List<Peliculas> mostrar() {
		// TODO Auto-generated method stub
		List<Peliculas> obtenerRegisTabla = peliculasDao.findAll();
		System.out.println(obtenerRegisTabla);
	    
		return obtenerRegisTabla;
	}

	@Transactional
	@Override
	public boolean guardar(Peliculas pelicula) {
		// TODO Auto-generated method stub
		boolean flag=false;
		for(Peliculas peli:mostrar()) {
			if(peli.getNombre().equalsIgnoreCase(pelicula.getNombre())) {
				flag=true;
				break;
			}
		}
		if(flag==false)
			peliculasDao.save(pelicula);
		return flag;
	}

	@Transactional(readOnly = true)
	@Override
	public Peliculas buscar(Integer idPelicula) {
		// TODO Auto-generated method stub
		Peliculas peliEnc = peliculasDao.findById(idPelicula).orElse(null);
	
		return peliEnc;
	}

	@Transactional
	@Override
	public boolean editar(Peliculas pelicula) {
		// TODO Auto-generated method stub
		if(buscar(pelicula.getIdPelicula())!=null) {
			peliculasDao.save(pelicula);
			return true;
		}else
			return false;
	}

	@Transactional
	@Override
	public boolean eliminar(Integer idPeli) {
		// TODO Auto-generated method stub
		if(buscar(idPeli)!=null) {
			peliculasDao.deleteById(idPeli);
			return true;
		}else
			return false;
	}

}
