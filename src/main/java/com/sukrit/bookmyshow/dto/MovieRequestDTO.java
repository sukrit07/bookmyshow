package com.sukrit.bookmyshow.dto;


import com.sukrit.bookmyshow.model.Actor;
import com.sukrit.bookmyshow.model.Feature;
import com.sukrit.bookmyshow.model.Genre;
import com.sukrit.bookmyshow.model.Movie;
import com.sukrit.bookmyshow.model.MovieLanguage;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import java.util.Date;
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
    private List<MovieLanguage> language;
    private List<Actor> actors;
    private List<Feature> movieFeatures;
    private List<Genre> genre;
    private Double duration;
    private Date releaseDate;
    private Boolean isActive;
}
