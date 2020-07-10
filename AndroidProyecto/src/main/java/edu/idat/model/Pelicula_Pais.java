package edu.idat.model;

import javax.persistence.*;

@Entity
@Table(name="pelicula_pais")
@IdClass(Pelicula_PaisPK.class)
public class Pelicula_Pais {

    @Id
    private Pelicula pelicula;

    @Id
    private Pais pais;

    @Column(name="fechaestreno", nullable=false)
    private String fechaEstreno;

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }
}
