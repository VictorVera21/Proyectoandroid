package edu.idat.model;

import javax.persistence.*;

@Entity
@Table(name="pelicula_actor")
@IdClass(Pelicula_ActorPK.class)
public class Pelicula_Actor {

    @Id
    private Pelicula pelicula;

    @Id
    private Actor actor;

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

}
