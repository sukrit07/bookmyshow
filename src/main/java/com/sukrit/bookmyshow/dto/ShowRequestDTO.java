package com.sukrit.bookmyshow.dto;


import com.sukrit.bookmyshow.model.Auditorium;
import com.sukrit.bookmyshow.model.Feature;
import com.sukrit.bookmyshow.model.Movie;
import com.sukrit.bookmyshow.model.ShowSeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ShowRequestDTO {

    private Movie movie;
    private Date startTime;
    private Date endTime;
    private Auditorium auditorium;
    private List<Feature> features;
    private List<ShowSeatTypePriceDTO> showSeatTypePriceList;
}
