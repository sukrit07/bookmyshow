package com.sukrit.bookmyshow.dto;

import com.sukrit.bookmyshow.model.Seat;
import com.sukrit.bookmyshow.model.ShowSeat;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookTicketResponseDTO {

    private String movieName;
    private Date showtime;
    private List<ShowSeat> seats;
    private Double amount;

}
