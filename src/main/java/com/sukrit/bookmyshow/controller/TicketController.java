package com.sukrit.bookmyshow.controller;

import com.sukrit.bookmyshow.dto.BookTicketRequestDTO;
import com.sukrit.bookmyshow.dto.BookTicketResponseDTO;
import com.sukrit.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket/book")
    public ResponseEntity<BookTicketResponseDTO> bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) {
        try {
            return ResponseEntity.ok(this.ticketService.bookTicket(bookTicketRequestDTO));
        } catch (Exception e) {
            System.out.println("Exception error");
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/ticket/details/{ticketId}")
    public ResponseEntity<BookTicketResponseDTO> getDetails(@PathVariable Long ticketId){
        try{
            return ResponseEntity.ok(this.ticketService.getTicketDetails(ticketId));
        }
        catch (Exception e){
            System.out.println("Exception thrown");
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
