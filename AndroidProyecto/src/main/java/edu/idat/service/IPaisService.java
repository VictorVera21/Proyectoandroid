package edu.idat.service;

import edu.idat.dto.ConsultaPaisDTO;
import edu.idat.model.Pais;

import java.util.List;

public interface IPaisService extends ICRUD<Pais,Long>{

    List<ConsultaPaisDTO> listarPaises(Long idPelicula);
}
