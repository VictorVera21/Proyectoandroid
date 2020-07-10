package edu.idat.service;

import edu.idat.dto.ConsultaPeliculaDTO;
import edu.idat.model.Pelicula;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IPeliculaService extends ICRUD<Pelicula,Long> {

    Pelicula registrarPeliculaDTO(ConsultaPeliculaDTO dto);

    Pelicula registrarPeliculaDTOPrueba(ConsultaPeliculaDTO dto);

    List<Pelicula> listarPeliculaInicial();

    List<Pelicula> findNombePeli(String pelicula);

    HashMap<String, Object> validate(Pelicula obj);
}
