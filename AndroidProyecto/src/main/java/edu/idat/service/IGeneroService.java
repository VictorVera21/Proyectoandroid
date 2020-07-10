package edu.idat.service;

import edu.idat.model.Genero;

import java.util.List;

public interface IGeneroService extends ICRUD<Genero,Long>{
    List<Genero> listarGeneros(Long idPelicula);
}
