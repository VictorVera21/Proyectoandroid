package edu.idat.controller;

import edu.idat.dto.ConsultaPeliculaDTO;
import edu.idat.model.Pelicula;
import edu.idat.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/peliculas")

public class PeliculaController {

    @Autowired
    private IPeliculaService service;

    @GetMapping
    public ResponseEntity<List<Pelicula>> listar(){
        List<Pelicula> oPelicula=service.listar();
        return new ResponseEntity<List<Pelicula>>(oPelicula, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> listarPorId(@PathVariable("id") Long id){
        Pelicula oPelicula=service.listarPorId(id);
        return new ResponseEntity<Pelicula>(oPelicula, HttpStatus.OK);
    }

    @GetMapping("/buscar/{pelicula}")
    public ResponseEntity<List<Pelicula>> findNombePeli(@PathVariable("pelicula") String pelicula){
        List<Pelicula> oPelicula=service.findNombePeli(pelicula);
        return new ResponseEntity<List<Pelicula>>(oPelicula, HttpStatus.OK);
    }

    @GetMapping("/listainicial")
    public ResponseEntity<List<Pelicula>> listarInicial(){
        List<Pelicula> oPelicula=service.listarPeliculaInicial();
        return new ResponseEntity<List<Pelicula>>(oPelicula, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pelicula> registrar(@Valid @RequestBody ConsultaPeliculaDTO obj){
        Pelicula oPelicula=service.registrarPeliculaDTO(obj);
        return new ResponseEntity<Pelicula>(oPelicula, HttpStatus.CREATED);
    }

    @PostMapping("/prueba")
    public ResponseEntity<Pelicula> registrarPrueba(@Valid @RequestBody ConsultaPeliculaDTO obj){
        Pelicula oPelicula=service.registrarPeliculaDTOPrueba(obj);
        return new ResponseEntity<Pelicula>(oPelicula, HttpStatus.CREATED);
    }

}
