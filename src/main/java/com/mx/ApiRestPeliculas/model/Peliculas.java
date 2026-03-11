package com.mx.ApiRestPeliculas.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Peliculas")
@NoArgsConstructor
@AllArgsConstructor

@Data

public class Peliculas {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name= "ID_PELICULA", columnDefinition = "INT", nullable =false)
private Integer idPelicula;

@Column(name="NOMBRE",columnDefinition = "VARCHAR2(100)", nullable =false)
private String nombre;

@Column(name="PRECIO",columnDefinition = "NUMBER(8,2)", nullable =false)
private String precio;

@Column(name="GENERO",columnDefinition = "VARCHAR2(100)", nullable =false)
private String genero;

@Column(name= "FECHA_LANZ", columnDefinition = "DATE", nullable = false)
private LocalDate fecha_lanz;

}
