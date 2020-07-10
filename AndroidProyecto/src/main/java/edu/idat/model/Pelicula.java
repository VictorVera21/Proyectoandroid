package edu.idat.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre de la pelicula no puede estar vacío")
    @Column(name="pelicula", length = 100, nullable = false)
    private String nomPeli;

    @NotEmpty(message = "La foto de la pelicula no puede estar vacío")
    @Column(name="foto", nullable = false)
    private String fotoPeli;

    @NotEmpty(message = "La descripcion de la pelicula no puede estar vacío")
    @Column(name="sinopsis", length = 1000, nullable = false)
    private String descripcion;

    @NotBlank
    @Column(name="lenguaje", length = 100, nullable = false)
    private String lenguaje;

    @NotEmpty(message = "El link del trailer de la pelicula no puede estar vacío")
    private String link;

    @NotEmpty(message = "El link del trailer de la pelicula no puede estar vacío")
    @Column(name="trailler", nullable = false)
    private String trailler;

    @ManyToOne
    @JoinColumn(name="iddirector", nullable=false, foreignKey = @ForeignKey(name="fk_pelicula_director"))
    private Director director;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomPeli() {
        return nomPeli;
    }

    public void setNomPeli(String nomPeli) {
        this.nomPeli = nomPeli;
    }

    public String getFotoPeli() {
        return fotoPeli;
    }

    public void setFotoPeli(String fotoPeli) {
        this.fotoPeli = fotoPeli;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTrailler() {
        return trailler;
    }

    public void setTrailler(String trailler) {
        this.trailler = trailler;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
