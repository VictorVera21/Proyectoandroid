package edu.idat.service.impl;

import edu.idat.model.Director;
import edu.idat.model.Pelicula_Genero;
import edu.idat.repo.IDirectorRepo;
import edu.idat.service.IDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImpl implements IDirectorService {


    @Autowired
    private IDirectorRepo repo;

    @Override
    public Director registrar(Director obj) {
        return repo.save(obj);
    }

    @Override
    public Director modificar(Director obj) {
        return repo.save(obj);
    }

    @Override
    public List<Director> listar() {
        return repo.findAll();
    }

    @Override
    public Director listarPorId(Long id) {
        Optional<Director> lista=repo.findById(id);
        return lista.isPresent() ? lista.get() : new Director();
    }

}
