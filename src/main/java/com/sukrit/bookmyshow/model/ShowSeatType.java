package com.sukrit.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "show_seattype_mapping")
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private double price;
}


/*
(123, Recliner)
(123, Gold)
(156, Recliner)
ShowSeatType ------- Show
     1    -          1
     M                1

 */
