package com.sukrit.bookmyshow.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseModel {
    @ManyToOne
    private Users bookedBy;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeats;

    private double totalAmount;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    private Date timeOfBooking;

    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;
}
