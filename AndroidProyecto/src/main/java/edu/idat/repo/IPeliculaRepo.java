package edu.idat.repo;

import edu.idat.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IPeliculaRepo extends JpaRepository<Pelicula,Long> {

    @Query(value="select * from pelicula  \n" +
            "order by 1 DESC limit 0,10",nativeQuery = true)
    List<Object[]> listarPeliculaInicial();

    @Query(value="SELECT * from pelicula where pelicula.pelicula = :pelicula", nativeQuery = true)
    List<Object[]> findNombePeli(String pelicula);

}
