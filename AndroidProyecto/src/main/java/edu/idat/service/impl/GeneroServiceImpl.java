package edu.idat.service.impl;

import edu.idat.model.Genero;
import edu.idat.repo.IGeneroRepo;
import edu.idat.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements IGeneroService {

    @Autowired
    private IGeneroRepo repo;

    @Override
    public Genero registrar(Genero obj) {
        return repo.save(obj);
    }

    @Override
    public Genero modificar(Genero obj) {
        return repo.save(obj);
    }

    @Override
    public List<Genero> listar() {
        return repo.findAll();
    }

    @Override
    public Genero listarPorId(Long id) {
        Optional<Genero> lista=repo.findById(id);
        return lista.isPresent() ? lista.get() : new Genero();
    }

    @Override
    public List<Genero> listarGeneros(Long idPelicula) {
        return repo.listarGeneros(idPelicula);
    }
}
