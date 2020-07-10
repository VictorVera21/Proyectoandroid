package edu.idat.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="genero")
public class Genero {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
    @Column(name="nombre", nullable=false, length=100)
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
