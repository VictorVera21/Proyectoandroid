package edu.idat.controller;

import edu.idat.model.Genero;
import edu.idat.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/generos")
public class GeneroController {

    @Autowired
    private IGeneroService service;

    @GetMapping
    public ResponseEntity<List<Genero>> listar(){
        List<Genero> lista=service.listar();
        return new ResponseEntity<List<Genero>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> listarPorId(@PathVariable("id") Long id){
        Genero genero=service.listarPorId(id);
        return new ResponseEntity<Genero>(genero,HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<Genero>> listarPorPelicula(@PathVariable("id") Long idPelicula){
        List<Genero> genero=service.listarGeneros(idPelicula);
        return new ResponseEntity<List<Genero>>(genero,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Genero> registrar(@Valid @RequestBody Genero obj){
        Genero oGenero=service.registrar(obj);
        return new ResponseEntity<Genero>(oGenero,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Genero> modificar(@RequestBody Genero obj){
        Genero oGenero=service.modificar(obj);
        return new ResponseEntity<Genero>(oGenero,HttpStatus.OK);
    }

}
