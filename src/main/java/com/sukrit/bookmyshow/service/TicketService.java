package com.sukrit.bookmyshow.service;

import com.sukrit.bookmyshow.builder.TicketEntityDTOBuilder;
import com.sukrit.bookmyshow.dto.BookTicketRequestDTO;
import com.sukrit.bookmyshow.dto.BookTicketResponseDTO;
import com.sukrit.bookmyshow.exception.ShowSeatNotFoundException;
import com.sukrit.bookmyshow.model.*;
import com.sukrit.bookmyshow.repository.ShowSeatRepository;
import com.sukrit.bookmyshow.repository.ShowSeatTypeMappingPriceRepository;
import com.sukrit.bookmyshow.repository.TicketRepository;
import com.sukrit.bookmyshow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowSeatTypeMappingPriceRepository showSeatPriceRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;

    public BookTicketResponseDTO getTicketDetails(Long ticketId){
        Ticket ticket = this.ticketRepository.findById(ticketId).get();
        BookTicketResponseDTO bookTicketResponseDTO = null;
        if(ticket != null){
            bookTicketResponseDTO = TicketEntityDTOBuilder.toBookTicketResponseDTO(ticket);
        }
        return bookTicketResponseDTO;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO bookTicketRequestDTO) throws Exception {
        List<Long> seatIdList = bookTicketRequestDTO.getShowSeatIds();

        //Steps:-

        //1. Fetch show Seats from the list of showSeatIds. (No lock)
        List<ShowSeat> showSeats = new ArrayList<>();
        showSeats = showSeatRepository.findAllByIdNoLock(seatIdList);
        /*for(Long showSeatId: bookTicketRequestDTO.getShowSeatIds()){
            ShowSeat showSeat = showSeatRepository.findById(showSeatId).get();
            showSeats.add(showSeat);
        }*/


        //2. Check the status of Show Seats.
        //3. If any one of them is not AVAILABLE then throw an exception.
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getState().equals(ShowSeatState.AVAILABLE)) {
                //throw an exception
                throw new ShowSeatNotFoundException(showSeat.getId());
            }
        }
        //4. Acquire the lock. -> call findAllByIdIn() with LOCK.
        //5. Check the status of Show Seats again.
        showSeats = showSeatRepository.findAllByIdIn(seatIdList); //WITH LOCK.


            //Check the status again for the all the show seats.
            int seatsLocked = 0;
            for (ShowSeat showSeat : showSeats) {
                if (showSeat.getState().equals(ShowSeatState.AVAILABLE)) {
                    showSeat.setState(ShowSeatState.LOCKED);
                    showSeatRepository.save(showSeat);
                    seatsLocked++;
                }
            }

            if (seatsLocked != showSeats.size()) {
                throw new Exception("Some issue in booking");
            }

            BookTicketResponseDTO bookTicketResponseDTO = new BookTicketResponseDTO();
            Ticket ticket = generateTicket(bookTicketRequestDTO, showSeats);

            for (ShowSeat showSeat : showSeats) {
                if (showSeat.getState().equals(ShowSeatState.AVAILABLE)) {
                    showSeat.setState(ShowSeatState.BOOKED);
                    showSeatRepository.save(showSeat);
                }
            }

            if (ticket.getTicketStatus().equals(TicketStatus.SUCCESS)) {
                bookTicketResponseDTO = TicketEntityDTOBuilder.toBookTicketResponseDTO(ticket);
            }

            return bookTicketResponseDTO;

    }


    private Ticket generateTicket(BookTicketRequestDTO bookRequest, List<ShowSeat> showSeats) throws Exception{
        Ticket ticket = new Ticket();
        HashMap<SeatType, Double> seatTypeAndPrice = new HashMap<>();

        Optional<Users> userOptional = userRepository.findById(bookRequest.getUserId());

        if (userOptional.isEmpty()) {
            throw new Exception("No user found");
        }
        for(ShowSeat seat: showSeats){
            if(!seatTypeAndPrice.containsKey(seat.getSeat().getSeatType())){
                ShowSeatType showAndSeatType = this.showSeatPriceRepository.findByShowAndSeatType(seat.getShow(),seat.getSeat().getSeatType());
                seatTypeAndPrice.put(seat.getSeat().getSeatType(), showAndSeatType.getPrice());
            }
        }

        ticket.setBookedBy(userOptional.get());
        ticket.setTicketStatus(TicketStatus.PENDING); //Ticket Status will be CONFIRMED only after payment.
        ticket.setShowSeats(showSeats);
        ticketRepository.save(ticket);
        Double amount = calculateAmt(showSeats,seatTypeAndPrice);
        Boolean isPaid =  doPayment(amount);
        if(isPaid)
        {
            ticket.setTicketStatus((TicketStatus.SUCCESS));
            ticketRepository.save(ticket);
        }
        return ticket;
    }

    private double calculateAmt(List<ShowSeat> showSeats, HashMap<SeatType, Double> seatPrices){
        double amount = 0.0;
        for(ShowSeat seat: showSeats){
            amount += seatPrices.get(seat.getSeat().getSeatType());
        }
        return amount;
    }

    private Boolean doPayment(double amount){
        return true;
    }
}
