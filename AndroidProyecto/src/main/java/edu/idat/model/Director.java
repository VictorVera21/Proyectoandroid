package edu.idat.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="director")
public class Director {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Los Apellidos no puede estar vacío")
    @Column(name="apellidos", length = 100, nullable = false)
    private String apellidosDir;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Column(name="nombres", nullable=false, length=100)
    private String nombreDir;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getApellidosDir() {
        return apellidosDir;
    }

    public void setApellidosDir(String apellidosDir) {
        this.apellidosDir = apellidosDir;
    }

    public String getNombreDir() {
        return nombreDir;
    }

    public void setNombreDir(String nombreDir) {
        this.nombreDir = nombreDir;
    }
}
