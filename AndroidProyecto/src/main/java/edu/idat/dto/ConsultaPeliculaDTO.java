package edu.idat.dto;

import edu.idat.model.*;

import java.util.List;

public class ConsultaPeliculaDTO {

    private Pelicula pelicula;

    private List<Actor> lstActor;

    private List<Genero> lstGenero;

    private List<Pelicula_Pais> lstPais;

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public List<Actor> getLstActor() {
        return lstActor;
    }

    public void setLstActor(List<Actor> lstActor) {
        this.lstActor = lstActor;
    }

    public List<Genero> getLstGenero() {
        return lstGenero;
    }

    public void setLstGenero(List<Genero> lstGenero) {
        this.lstGenero = lstGenero;
    }

    public List<Pelicula_Pais> getLstPais() {
        return lstPais;
    }

    public void setLstPais(List<Pelicula_Pais> lstPais) {
        this.lstPais = lstPais;
    }
}
