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

    @OneToMany
    private List<Seat> seats;

    @OneToMany(mappedBy = "auditorium")
    private List<Show> shows;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Feature> auditoriumFeatures;
}
