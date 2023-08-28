package com.sukrit.bookmyshow.dto;

import com.sukrit.bookmyshow.model.Seat;
import com.sukrit.bookmyshow.model.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BookTicketResponseDTO {

    private String movieName;
    private Date showtime;
    private List<ShowSeat> seats;
    private Double amount;

}
