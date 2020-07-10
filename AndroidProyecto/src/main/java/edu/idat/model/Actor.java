package edu.idat.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="actor")
public class Actor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo de Apellidos no puede estar vacío")
    @Column(name="apellidos", length = 100, nullable = false)
    private String apellidosActor;

    @NotEmpty(message = "El campo de nombre no puede estar vacío")
    @Column(name="nombres", nullable=false, length=100)
    private String nombreActor;

    @NotEmpty(message = "La foto de la pelicula no puede estar vacío")
    @Column(name="foto", nullable=false, length=1000)
    private String fotoActor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellidosActor() {
        return apellidosActor;
    }

    public void setApellidosActor(String apellidosActor) {
        this.apellidosActor = apellidosActor;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }

    public String getFotoActor() {
        return fotoActor;
    }

    public void setFotoActor(String fotoActor) {
        this.fotoActor = fotoActor;
    }
}
