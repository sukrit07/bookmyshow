package com.sukrit.bookmyshow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
