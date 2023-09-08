package com.sukrit.bookmyshow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookTicketRequestDTO {

    @NotEmpty(message = "Select atleast 1 show to Book")
    private Long showId;

    @NotEmpty(message = "Select atleast 1 User to Book")
    private Long userId;

    @NotEmpty(message = "Select atleast 1 Seat to Book")
    private List<Long> showSeatIds;
}
