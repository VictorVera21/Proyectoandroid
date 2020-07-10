package edu.idat.controller;

import edu.idat.model.Director;
import edu.idat.model.Pais;
import edu.idat.service.IDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/directores")
public class DirectorController {

    @Autowired
    private IDirectorService service;

    @GetMapping
    public ResponseEntity<List<Director>> listar(){
        List<Director> lista=service.listar();
        return new ResponseEntity<List<Director>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> listarPorId(@PathVariable("id") Long id){
        Director director=service.listarPorId(id);
        return new ResponseEntity<Director>(director,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Director> registrar(@Valid @RequestBody Director obj){
        Director oDirector=service.registrar(obj);
        return new ResponseEntity<Director>(oDirector,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Director> modificar(@RequestBody Director obj){
        Director oDirector=service.modificar(obj);
        return new ResponseEntity<Director>(oDirector,HttpStatus.OK);
    }
}
