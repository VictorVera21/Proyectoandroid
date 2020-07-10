package edu.idat.repo;

import edu.idat.model.Pelicula_Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IPelicula_ActorRepo extends JpaRepository<Pelicula_Actor,Long> {

    //@Transactional
    @Modifying
    @Query(value="insert into pelicula_actor(idpelicula,idactor) values(:id_pelicula,:id_actor)", nativeQuery = true)
    Integer registrar(@Param("id_pelicula") Long id_pelicula,@Param("id_actor") Long id_actor);
}
