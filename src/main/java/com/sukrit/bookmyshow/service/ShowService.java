package com.sukrit.bookmyshow.service;


import com.sukrit.bookmyshow.builder.ShowEntityDTOBuilder;
import com.sukrit.bookmyshow.dto.ShowRequestDTO;
import com.sukrit.bookmyshow.dto.ShowResponseDTO;
import com.sukrit.bookmyshow.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public ShowResponseDTO addShow(ShowRequestDTO showRequestDTO){
        return ShowEntityDTOBuilder.toDto(showRepository.save(ShowEntityDTOBuilder.toEntity(showRequestDTO)));
    }
}
