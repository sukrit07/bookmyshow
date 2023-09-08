package com.sukrit.bookmyshow.builder;


import com.sukrit.bookmyshow.dto.MovieRequestDTO;
import com.sukrit.bookmyshow.dto.MovieResponseDTO;
import com.sukrit.bookmyshow.dto.TheatreRequestDTO;
import com.sukrit.bookmyshow.dto.TheatreResponseDTO;
import com.sukrit.bookmyshow.model.Movie;
import com.sukrit.bookmyshow.model.Theatre;

public class TheatreEntityDTOBuilder {
    public static Theatre toEntity(TheatreRequestDTO theatreRequestDTO){
        return Theatre.builder()
                .name(theatreRequestDTO.getName())
                .city(theatreRequestDTO.getCity())
                .address(theatreRequestDTO.getAddress())
                .auditoriums(theatreRequestDTO.getAuditoriums())
                .build();
    }

    public static TheatreResponseDTO toDto(Theatre theatre){
        return TheatreResponseDTO.builder()
                .name(theatre.getName())
                .city(theatre.getCity())
                .address(theatre.getAddress())
                .auditoriums(theatre.getAuditoriums())
                .build();
    }
}
