package edu.idat.service.impl;

import edu.idat.dto.ConsultaPeliculaDTO;
import edu.idat.model.*;
import edu.idat.repo.IPeliculaRepo;
import edu.idat.repo.IPelicula_ActorRepo;
import edu.idat.repo.IPelicula_GeneroRepo;
import edu.idat.repo.IPelicula_PaisRepo;
import edu.idat.service.IDirectorService;
import edu.idat.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PeliculaServiceImpl implements IPeliculaService {

    @Autowired
    private IPeliculaRepo repo;

    @Autowired
    private IPelicula_ActorRepo cerepo;

    @Autowired
    private IPelicula_GeneroRepo generepo;

    @Autowired
    private IPelicula_PaisRepo paisrepo;

    @Autowired
    private IDirectorService dirser;

    @Autowired
    private IDirectorService repoDir;

    @Override
    public Pelicula registrar(Pelicula obj) {
        return repo.save(obj);
    }

    @Override
    public Pelicula modificar(Pelicula obj) {
        return null;
    }

    @Override
    public List<Pelicula> listar() {
        return repo.findAll();
    }

    @Override
    public Pelicula listarPorId(Long id) {
        Optional<Pelicula> lista=repo.findById(id);
        return lista.isPresent() ? lista.get() : new Pelicula();
    }

    @Transactional
    @Override
    public Pelicula registrarPeliculaDTO(ConsultaPeliculaDTO dto) {
        repo.save(dto.getPelicula());
        dto.getLstActor().forEach(ex->cerepo.registrar(dto.getPelicula().getId(),ex.getId()));
        dto.getLstGenero().forEach(ex->generepo.registrarPeliconGene(dto.getPelicula().getId(),ex.getId()));
        dto.getLstPais().forEach(ex->paisrepo.registrarPeliconPais(dto.getPelicula().getId(),ex.getPais().getId(),ex.getFechaEstreno()));

        return dto.getPelicula();
    }

    @Override
    public List<Pelicula> listarPeliculaInicial() {
        //return repo.listarPeliculaInicial();
        List<Pelicula> pelicula=new ArrayList<>();
        repo.listarPeliculaInicial().forEach(x -> {
            Pelicula peli=new Pelicula();
            peli.setId(Long.parseLong(String.valueOf(x[0])));
            peli.setDescripcion(String.valueOf(x[1]));
            peli.setFotoPeli(String.valueOf(x[2]));
            peli.setLenguaje(String.valueOf(x[3]));
            peli.setLink(String.valueOf(x[4]));
            peli.setNomPeli(String.valueOf(x[5]));
            Director director= new Director();
            director=repoDir.listarPorId(Long.parseLong(String.valueOf(x[6])));
            //genero.setId(Integer.parseInt(String.valueOf(x[6])));
            peli.setDirector(director);

            pelicula.add(peli);
        });
        return pelicula;
    }

    @Override
    public List<Pelicula> findNombePeli(String pelicula) {
        List<Pelicula> peliculas=new ArrayList<>();
        repo.findNombePeli(pelicula).forEach(x -> {
            Pelicula peli=new Pelicula();
            peli.setId(Long.parseLong(String.valueOf(x[0])));
            peli.setDescripcion(String.valueOf(x[1]));
            peli.setFotoPeli(String.valueOf(x[2]));
            peli.setLenguaje(String.valueOf(x[3]));
            peli.setLink(String.valueOf(x[4]));
            peli.setNomPeli(String.valueOf(x[5]));
            Director director= new Director();
            director=repoDir.listarPorId(Long.parseLong(String.valueOf(x[6])));
            //genero.setId(Integer.parseInt(String.valueOf(x[6])));
            peli.setDirector(director);

            peliculas.add(peli);
        });
        return peliculas;
    }

    @Override
    public HashMap<String, Object> validate(Pelicula obj) {
        HashMap errors = new HashMap();
        if (repo.findNombePeli(obj.getNomPeli()).isEmpty()) {
           errors.put("nombre", String.format("El nombre de la pelicula '%s' ya existe", obj.getNomPeli()));
        }
        return errors;
    }


    @Override
    public Pelicula registrarPeliculaDTOPrueba(ConsultaPeliculaDTO dto) {

        HashMap<String, Object> errorsPelicula;
        errorsPelicula = validate(dto.getPelicula());

        String rpta = "";

        if (errorsPelicula.size() == 0){
            repo.save(dto.getPelicula());
            dto.getLstActor().forEach(ex->cerepo.registrar(dto.getPelicula().getId(),ex.getId()));
            dto.getLstGenero().forEach(ex->generepo.registrarPeliconGene(dto.getPelicula().getId(),ex.getId()));
            dto.getLstPais().forEach(ex->paisrepo.registrarPeliconPais(dto.getPelicula().getId(),ex.getPais().getId(),ex.getFechaEstreno()));

        }else {
            HashMap<String, Object> allErrors = new HashMap<>();
            allErrors.put("pelicula", errorsPelicula);
        }

        return dto.getPelicula();
    }
}
