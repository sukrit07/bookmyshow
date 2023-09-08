package com.sukrit.bookmyshow.model;
import jakarta.persistence.*;
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

    @ManyToMany
    private List<Actor> actors;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> movieFeatures;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Genre> genre;

    private Double duration;
}
