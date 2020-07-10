package edu.idat.repo;

import edu.idat.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDirectorRepo extends JpaRepository<Director, Long> {
}
