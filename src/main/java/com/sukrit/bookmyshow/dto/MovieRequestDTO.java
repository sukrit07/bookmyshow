package com.sukrit.bookmyshow.dto;


import com.sukrit.bookmyshow.model.Actor;
import com.sukrit.bookmyshow.model.Feature;
import com.sukrit.bookmyshow.model.Genre;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class MovieRequestDTO {
    private String name;
    private List<Actor> actors;
    private List<Feature> movieFeatures;
    private List<Genre> genre;
    private Double duration;
}
