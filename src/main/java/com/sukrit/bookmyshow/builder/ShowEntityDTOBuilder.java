package com.sukrit.bookmyshow.builder;

import com.sukrit.bookmyshow.dto.ShowRequestDTO;
import com.sukrit.bookmyshow.dto.ShowResponseDTO;
import com.sukrit.bookmyshow.model.Show;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowEntityDTOBuilder {

    public static ShowResponseDTO toDto(Show show){
        return ShowResponseDTO.builder()
                .movie(show.getMovie())
                .startTime(show.getStartTime())
                .endTime(show.getEndTime())
                .auditorium(show.getAuditorium())
                .features(show.getFeatures())
                .build();
    }

    public static Show toEntity(ShowRequestDTO show){
        return Show.builder()
                .movie(show.getMovie())
                .startTime(show.getStartTime())
                .endTime(show.getEndTime())
                .auditorium(show.getAuditorium())
                .features(show.getFeatures())
                .build();
    }
}
