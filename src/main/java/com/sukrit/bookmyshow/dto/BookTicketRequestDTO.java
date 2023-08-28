package com.sukrit.bookmyshow.dto;

import lombok.Data;


import java.util.List;

@Data
public class BookTicketRequestDTO {
    private Long showId;
    private Long userId;
    private List<Long> showSeatIds;
}
