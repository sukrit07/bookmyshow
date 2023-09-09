package com.sukrit.bookmyshow.service;


import com.sukrit.bookmyshow.builder.ShowEntityDTOBuilder;
import com.sukrit.bookmyshow.dto.ShowRequestDTO;
import com.sukrit.bookmyshow.dto.ShowResponseDTO;
import com.sukrit.bookmyshow.dto.ShowSeatTypePriceDTO;
import com.sukrit.bookmyshow.model.Seat;
import com.sukrit.bookmyshow.model.Show;
import com.sukrit.bookmyshow.model.ShowSeat;
import com.sukrit.bookmyshow.model.ShowSeatState;
import com.sukrit.bookmyshow.model.ShowSeatType;
import com.sukrit.bookmyshow.repository.ShowRepository;
import com.sukrit.bookmyshow.repository.ShowSeatRepository;
import com.sukrit.bookmyshow.repository.ShowSeatTypeMappingPriceRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

  @Autowired
  private ShowRepository showRepository;

  @Autowired
  private ShowSeatRepository showSeatRepository;

  @Autowired
  private ShowSeatTypeMappingPriceRepository showSeatTypeMappingPriceRepo;

  public ShowResponseDTO addShow(ShowRequestDTO showRequestDTO) {
    Show show = ShowEntityDTOBuilder.toEntity(showRequestDTO);
    show = showRepository.save(show);
    generateSeatsForShow(show);
    generateSeatPricesForShow(showRequestDTO, show);
    return ShowEntityDTOBuilder.toDto(show);
  }

  public void generateSeatsForShow(Show show) {
    List<Seat> seatList = show.getAuditorium().getSeats();
    List<ShowSeat> showSeats = seatList.stream().map(seat -> ShowSeat.builder()
        .show(show)
        .state(ShowSeatState.AVAILABLE)
        .seat(seat)
        .build()).toList();
    this.showSeatRepository.saveAll(showSeats);
  }

  public void generateSeatPricesForShow(ShowRequestDTO requestDTO, Show show) {
    List<ShowSeatTypePriceDTO> showSeatTypePriceList = requestDTO.getShowSeatTypePriceList();
    List<ShowSeatType> showSeatTypes =
        showSeatTypePriceList.stream().map(seat -> ShowSeatType.builder()
            .show(show)
            .seatType(seat.getSeatType())
            .price(seat.getPrice())
            .build()).toList();
    this.showSeatTypeMappingPriceRepo.saveAll(showSeatTypes);
  }
}
