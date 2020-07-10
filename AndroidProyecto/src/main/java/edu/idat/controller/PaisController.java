package edu.idat.controller;

import edu.idat.dto.ConsultaPaisDTO;
import edu.idat.model.Pais;
import edu.idat.service.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/paises")
public class PaisController {

    @Autowired
    private IPaisService service;

    @GetMapping
    public ResponseEntity<List<Pais>> listar(){
        List<Pais> lista=service.listar();
        return new ResponseEntity<List<Pais>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> listarPorId(@PathVariable("id") Long id){
        Pais pais=service.listarPorId(id);
        return new ResponseEntity<Pais>(pais,HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<ConsultaPaisDTO>> listarPorPelicula(@PathVariable("id") Long idPelicula){
        List<ConsultaPaisDTO> pais=service.listarPaises(idPelicula);
        return new ResponseEntity<List<ConsultaPaisDTO>>(pais,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pais> registrar(@Valid @RequestBody Pais obj){
        Pais oPais=service.registrar(obj);
        return new ResponseEntity<Pais>(oPais,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pais> modificar(@RequestBody Pais obj){
        Pais oPais=service.modificar(obj);
        return new ResponseEntity<Pais>(oPais,HttpStatus.OK);
    }
}
