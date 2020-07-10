package edu.idat.service.impl;

import edu.idat.dto.ConsultaPaisDTO;
import edu.idat.model.Pais;
import edu.idat.repo.IPaisRepo;
import edu.idat.service.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements IPaisService {

    @Autowired
    private IPaisRepo repo;

    @Override
    public Pais registrar(Pais obj) {
        return repo.save(obj);
    }

    @Override
    public Pais modificar(Pais obj) {
        return repo.save(obj);
    }

    @Override
    public List<Pais> listar() {
        return repo.findAll();
    }

    @Override
    public Pais listarPorId(Long id) {
        Optional<Pais> lista=repo.findById(id);
        return lista.isPresent() ? lista.get() : new Pais();
    }

    @Override
    public List<ConsultaPaisDTO> listarPaises(Long idPelicula) {
        List<ConsultaPaisDTO> listaPais=new ArrayList<>();
        repo.listarPaises(idPelicula).forEach(x->{
            ConsultaPaisDTO oPais=new ConsultaPaisDTO();
            oPais.setId(Long.parseLong(String.valueOf(x[0])));
            oPais.setNombre(String.valueOf(x[1]));
            oPais.setFecha(String.valueOf(x[2]));
            listaPais.add(oPais);
        });
        return listaPais;

    }
}
