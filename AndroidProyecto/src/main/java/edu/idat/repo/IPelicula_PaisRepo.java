package edu.idat.repo;

import edu.idat.model.Pelicula_Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPelicula_PaisRepo extends JpaRepository<Pelicula_Pais,Long> {

    @Modifying
    @Query(value="insert into pelicula_pais(idpelicula,idpais,fechaestreno) values(:id_pelicula,:id_pais,:fecha_estreno)", nativeQuery = true)
    Integer registrarPeliconPais(@Param("id_pelicula") Long id_pelicula, @Param("id_pais") Long id_pais, @Param("fecha_estreno") String fecha_estreno);
}
