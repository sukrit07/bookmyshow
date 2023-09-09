package com.sukrit.bookmyshow.model;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
// @Data -> To provide getter and setters both.
public class Movie extends BaseModel {
    private String name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieLanguage> language;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Actor> actors;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> movieFeatures;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Genre> genre;

    private Double duration;
    private Date releaseDate;
    private Boolean isActive;
}
