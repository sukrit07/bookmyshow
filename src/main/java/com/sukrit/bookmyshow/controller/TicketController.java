package com.sukrit.bookmyshow.controller;

import com.sukrit.bookmyshow.dto.BookTicketRequestDTO;
import com.sukrit.bookmyshow.dto.BookTicketResponseDTO;
import com.sukrit.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket/book")
    public BookTicketResponseDTO bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) {
        try {
            return this.ticketService.bookTicket(bookTicketRequestDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
