package edu.idat.service.impl;

import edu.idat.model.Actor;
import edu.idat.repo.IActorRepo;
import edu.idat.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ActorServiceImpl implements IActorService {

    @Autowired
    private IActorRepo repo;

    @Override
    public Actor registrar(Actor obj) {
        return repo.save(obj);
    }

    @Override
    public Actor modificar(Actor obj) {
        return repo.save(obj);
    }

    @Override
    public List<Actor> listar() {
        return repo.findAll();
    }

    @Override
    public Actor listarPorId(Long id) {
        Optional<Actor> lista=repo.findById(id);
        return lista.isPresent() ? lista.get() : new Actor();
    }

    @Override
    public List<Actor> listarActores(Long idPelicula) {
        return repo.listarActores(idPelicula);
    }
}
