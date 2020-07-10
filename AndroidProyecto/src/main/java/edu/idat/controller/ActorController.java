package edu.idat.controller;

import edu.idat.model.Actor;
import edu.idat.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/actores")
public class ActorController {

    @Autowired
    private IActorService service;

    @GetMapping
    public ResponseEntity<List<Actor>> listar(){
        List<Actor> lista=service.listar();
        return new ResponseEntity<List<Actor>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> listarPorId(@PathVariable("id") Long id){
        Actor oActor=service.listarPorId(id);
        return new ResponseEntity<Actor>(oActor,HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<Actor>> listarPorPelicula(@PathVariable("id") Long idPelicula){
        List<Actor> oActor=service.listarActores(idPelicula);
        return new ResponseEntity<List<Actor>>(oActor,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Actor> registrar(@Valid @RequestBody Actor obj){
        Actor oActor=service.registrar(obj);
        return new ResponseEntity<Actor>(oActor,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Actor> modificar(@RequestBody Actor obj){
        Actor oActor=service.modificar(obj);
        return new ResponseEntity<Actor>(oActor,HttpStatus.OK);
    }
}
