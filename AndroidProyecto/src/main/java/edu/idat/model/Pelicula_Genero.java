package edu.idat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="pelicula_genero")
@IdClass(Pelicula_GeneroPK.class)
public class Pelicula_Genero {

    @Id
    private Pelicula pelicula;

    @Id
    private Genero genero;

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
