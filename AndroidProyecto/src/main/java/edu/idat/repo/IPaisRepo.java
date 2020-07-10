package edu.idat.repo;

import edu.idat.model.Actor;
import edu.idat.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPaisRepo extends JpaRepository<Pais, Long> {
    @Query(value="SELECT pais.id,pais.nombre,pelicula_pais.fechaestreno\n" +
            "FROM pais inner join pelicula_pais\n" +
            "on pais.id=pelicula_pais.idpais\n" +
            "where pelicula_pais.idpelicula=:idpelicula",nativeQuery = true)
    List<Object[]> listarPaises(@Param("idpelicula") Long idPelicula);
}
