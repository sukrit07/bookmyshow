package com.sukrit.bookmyshow.builder;


import com.sukrit.bookmyshow.dto.MovieRequestDTO;
import com.sukrit.bookmyshow.dto.MovieResponseDTO;
import com.sukrit.bookmyshow.dto.UserRequestDTO;
import com.sukrit.bookmyshow.model.Movie;
import com.sukrit.bookmyshow.model.Users;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieEntityDTOBuilder {
    public static Movie toEntity(MovieRequestDTO movieRequestDTO){
        return Movie.builder()
                .name(movieRequestDTO.getName())
                .genre(movieRequestDTO.getGenre())
                .duration(movieRequestDTO.getDuration())
                .movieFeatures(movieRequestDTO.getMovieFeatures())
                .actors(movieRequestDTO.getActors())
                .build();
    }

    public static MovieResponseDTO toDto(Movie movie){
        return MovieResponseDTO.builder()
                .name(movie.getName())
                .genre(movie.getGenre())
                .duration(movie.getDuration())
                .movieFeatures(movie.getMovieFeatures())
                .actors(movie.getActors())
                .build();
    }
}
