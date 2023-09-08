package com.sukrit.bookmyshow.dto;

import com.sukrit.bookmyshow.model.Auditorium;
import com.sukrit.bookmyshow.model.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class TheatreResponseDTO {
    private String name;
    private String address;
    private List<Auditorium> auditoriums;
    private City city;
}
