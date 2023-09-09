package com.sukrit.bookmyshow.dto;

import com.sukrit.bookmyshow.model.SeatType;
import lombok.Data;

@Data
public class ShowSeatTypePriceDTO {

  private SeatType seatType;
  private Double price;

}
