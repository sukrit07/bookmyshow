package com.sukrit.bookmyshow.repository;

import com.sukrit.bookmyshow.model.SeatType;
import com.sukrit.bookmyshow.model.Show;
import com.sukrit.bookmyshow.model.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatTypeMappingPriceRepository extends JpaRepository<ShowSeatType, Long> {
    ShowSeatType findByShowAndSeatType(Show show, SeatType seatType);
}
