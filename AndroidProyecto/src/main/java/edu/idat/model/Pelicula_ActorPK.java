package edu.idat.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Pelicula_ActorPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="idpelicula", nullable=false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name="idactor", nullable=false)
    private Actor actor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula_ActorPK that = (Pelicula_ActorPK) o;
        return Objects.equals(pelicula, that.pelicula) &&
                Objects.equals(actor, that.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pelicula, actor);
    }
}
