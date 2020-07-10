package edu.idat.service;

import edu.idat.model.Actor;

import java.util.List;

public interface IActorService extends ICRUD<Actor,Long> {

    List<Actor> listarActores(Long idPelicula);
}
