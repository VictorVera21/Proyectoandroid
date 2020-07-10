package edu.idat.repo;

import edu.idat.model.Pelicula_Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPelicula_GeneroRepo extends JpaRepository<Pelicula_Genero,Long> {

    @Modifying
    @Query(value="insert into pelicula_genero(idpelicula,idgenero) values(:id_pelicula,:id_genero)", nativeQuery = true)
    Integer registrarPeliconGene(@Param("id_pelicula") Long id_pelicula, @Param("id_genero") Long id_genero);

}
