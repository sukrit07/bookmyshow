package com.sukrit.bookmyshow.controller;

import com.sukrit.bookmyshow.constants.AppConstants;
import com.sukrit.bookmyshow.dto.MovieRequestDTO;
import com.sukrit.bookmyshow.dto.MovieResponseDTO;
import com.sukrit.bookmyshow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<List<MovieResponseDTO>> addMovie(@RequestBody List<MovieRequestDTO> movieRequestDTO){
        return ResponseEntity.ok(movieService.addMovie(movieRequestDTO));
    }

    @PutMapping("/edit")
    public ResponseEntity<List<MovieResponseDTO>> editMovie(@RequestBody List<MovieRequestDTO> movieRequestDTO) {
        return ResponseEntity.ok(movieService.updateMovie(movieRequestDTO));
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieResponseDTO> getMovieDetails(@PathVariable Long movieId){
        return ResponseEntity.ok(movieService.getDetails(movieId));
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieResponseDTO>> getAllMovieDetails(){
        return ResponseEntity.ok(movieService.getMoviesList(  ));
    }

    @GetMapping("/getListOfMovie/")
    public ResponseEntity<List<MovieResponseDTO>> getMovieListByPageAndSort(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                                                     @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int offset,
                                                                     @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                                                     @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir){
        return ResponseEntity.ok(movieService.getMoviesListInPagination(offset,pageNo, sortDir, sortBy));
    }
}
