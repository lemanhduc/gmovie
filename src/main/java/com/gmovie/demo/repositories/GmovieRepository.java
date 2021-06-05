package com.gmovie.demo.repositories;
import com.gmovie.demo.domain.GMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface GmovieRepository extends CrudRepository<GMovies, Integer> {
}
