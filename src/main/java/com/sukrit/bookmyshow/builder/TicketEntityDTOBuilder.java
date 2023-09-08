package com.sukrit.bookmyshow.builder;

import com.sukrit.bookmyshow.dto.BookTicketRequestDTO;
import com.sukrit.bookmyshow.dto.BookTicketResponseDTO;
import com.sukrit.bookmyshow.model.Ticket;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

@UtilityClass
public class TicketEntityDTOBuilder {
    public static BookTicketResponseDTO toBookTicketResponseDTO(Ticket ticket){
        return BookTicketResponseDTO.builder()
                .movieName(ticket.getShow().getMovie().getName())
                .seats(ticket.getShowSeats())
                .amount(ticket.getTotalAmount())
                .showtime(ticket.getShow().getStartTime())
                .build();
    }
}
