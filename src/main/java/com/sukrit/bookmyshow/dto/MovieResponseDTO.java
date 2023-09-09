package com.sukrit.bookmyshow.dto;


import com.sukrit.bookmyshow.model.Actor;
import com.sukrit.bookmyshow.model.Feature;
import com.sukrit.bookmyshow.model.Genre;
import com.sukrit.bookmyshow.model.MovieLanguage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class MovieResponseDTO {
    private String name;
    private List<MovieLanguage> language;
    private List<Actor> actors;
    private Double duration;
    private List<Feature> movieFeatures;
    private List<Genre> genre;
}
