package com.sukrit.bookmyshow.repository;

import com.sukrit.bookmyshow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
