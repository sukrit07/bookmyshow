package com.sukrit.bookmyshow.repository;

import com.sukrit.bookmyshow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    boolean existsMovieByName(String name);
}
