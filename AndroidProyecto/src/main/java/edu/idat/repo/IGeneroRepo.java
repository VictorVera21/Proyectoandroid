package edu.idat.repo;

import edu.idat.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGeneroRepo extends JpaRepository<Genero,Long> {
    @Query(value="select genero.id,genero.nombre\n" +
            "from genero inner join pelicula_genero\n" +
            "on genero.id=pelicula_genero.idgenero\n" +
            "where pelicula_genero.idpelicula=:idpelicula",nativeQuery = true)
    List<Genero> listarGeneros(@Param("idpelicula") Long idPelicula);
}
