package com.sukrit.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel{

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Seat> seats;

    @OneToMany(mappedBy = "auditorium" ,cascade = CascadeType.ALL)
    private List<Show> shows;

    @ManyToOne(cascade = CascadeType.ALL)
    private Theatre theatre;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Feature> auditoriumFeatures;
}
