package edu.idat.repo;

import edu.idat.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorRepo extends JpaRepository<Actor,Long> {
    @Query(value="SELECT actor.id, actor.apellidos, actor.nombres, \n" +
            "actor.foto FROM pelicula_actor \n" +
            "inner join actor on pelicula_actor.idactor = actor.id\n" +
            "WHERE pelicula_actor.idpelicula =:idpelicula",nativeQuery = true)
    List<Actor> listarActores(@Param("idpelicula") Long idPelicula);
}
