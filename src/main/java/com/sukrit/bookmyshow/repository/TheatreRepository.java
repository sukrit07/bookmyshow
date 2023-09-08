package com.sukrit.bookmyshow.repository;

import com.sukrit.bookmyshow.model.City;
import com.sukrit.bookmyshow.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    List<Theatre> findTheatresByCity(City city);
}
