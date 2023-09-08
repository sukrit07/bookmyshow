package com.sukrit.bookmyshow.controller;

import com.sukrit.bookmyshow.dto.TheatreRequestDTO;
import com.sukrit.bookmyshow.dto.TheatreResponseDTO;
import com.sukrit.bookmyshow.model.City;
import com.sukrit.bookmyshow.model.Theatre;
import com.sukrit.bookmyshow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("/add")
    public ResponseEntity<TheatreResponseDTO> addTheatre(@RequestBody TheatreRequestDTO theaterDto) {

        return ResponseEntity.ok(theatreService.addTheater(theaterDto));
    }

    @GetMapping("/getTheatresOfCity")
    public ResponseEntity<List<TheatreResponseDTO>> getTheatreOfCity(@RequestBody City city) {

        return ResponseEntity.ok(theatreService.getTheatresOfCity(city));
    }
}
