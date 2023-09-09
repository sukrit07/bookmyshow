package com.sukrit.bookmyshow.repository;

import com.sukrit.bookmyshow.model.City;
import com.sukrit.bookmyshow.model.Theatre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    List<Theatre> findTheatresByCity(City city);
}
