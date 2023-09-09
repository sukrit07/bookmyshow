package com.sukrit.bookmyshow.repository;

import com.sukrit.bookmyshow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShowRepository extends JpaRepository<Show, Long> {
}
