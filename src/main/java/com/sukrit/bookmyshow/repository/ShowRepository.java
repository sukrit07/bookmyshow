package com.sukrit.bookmyshow.repository;

import com.sukrit.bookmyshow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}
