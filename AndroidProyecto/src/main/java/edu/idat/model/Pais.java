package edu.idat.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Debe tener minimo 3 caracteres")
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
