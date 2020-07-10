package edu.idat.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Pelicula_PaisPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="idpelicula", nullable=false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name="idpais", nullable=false)
    private Pais pais;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula_PaisPK that = (Pelicula_PaisPK) o;
        return Objects.equals(pelicula, that.pelicula) &&
                Objects.equals(pais, that.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pelicula, pais);
    }
}
