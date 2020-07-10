package edu.idat.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Pelicula_GeneroPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="idpelicula", nullable=false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name="idgenero", nullable=false)
    private Genero genero;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula_GeneroPK that = (Pelicula_GeneroPK) o;
        return Objects.equals(pelicula, that.pelicula) &&
                Objects.equals(genero, that.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pelicula, genero);
    }
}
