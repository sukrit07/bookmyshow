package com.sukrit.bookmyshow.controller;

import com.sukrit.bookmyshow.dto.ShowRequestDTO;
import com.sukrit.bookmyshow.dto.ShowResponseDTO;
import com.sukrit.bookmyshow.model.Show;
import com.sukrit.bookmyshow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<ShowResponseDTO> addShow(@RequestBody ShowRequestDTO showRequestDTO){
            return ResponseEntity.ok(showService.addShow(showRequestDTO));
    }
}
