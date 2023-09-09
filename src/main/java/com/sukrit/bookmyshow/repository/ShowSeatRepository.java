package com.sukrit.bookmyshow.repository;

import com.sukrit.bookmyshow.model.ShowSeat;
import jakarta.persistence.LockModeType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Override
    Optional<ShowSeat> findById(Long showSeatId);
    //select * from show_seat where id = showSeatId

    //select * from show_seat where Id in (....) for update.
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllByIdIn(List<Long> showSeatId);
    //select * from show_seat where id IN (4,5,6,7);

    @Query("select ss from ShowSeat ss where ss.id in ?1")
    List<ShowSeat> findAllByIdNoLock(List<Long> showSeatId);

    ShowSeat save(ShowSeat showSeat); // UPSERT -> UPDATE + INSERT

}
