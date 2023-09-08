package com.sukrit.bookmyshow.service;


import com.sukrit.bookmyshow.builder.TheatreEntityDTOBuilder;
import com.sukrit.bookmyshow.dto.TheatreRequestDTO;
import com.sukrit.bookmyshow.dto.TheatreResponseDTO;
import com.sukrit.bookmyshow.model.City;
import com.sukrit.bookmyshow.model.Theatre;
import com.sukrit.bookmyshow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public TheatreResponseDTO addTheater(TheatreRequestDTO theaterDto) {

        Theatre theaterEntity = TheatreEntityDTOBuilder.toEntity(theaterDto);

        //theaterEntity.getSeats().addAll(getTheaterSeats());

        theaterEntity = theatreRepository.save(theaterEntity);
        return TheatreEntityDTOBuilder.toDto(theaterEntity);
    }

    public List<TheatreResponseDTO> getTheatresOfCity(City city) {
        List<Theatre> theatres = theatreRepository.findTheatresByCity(city);
        return theatres.stream().map(TheatreEntityDTOBuilder::toDto).toList();
    }

}
