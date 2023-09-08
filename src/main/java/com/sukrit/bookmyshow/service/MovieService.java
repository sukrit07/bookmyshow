package com.sukrit.bookmyshow.service;

import com.sukrit.bookmyshow.builder.MovieEntityDTOBuilder;
import com.sukrit.bookmyshow.dto.MovieRequestDTO;
import com.sukrit.bookmyshow.dto.MovieResponseDTO;
import com.sukrit.bookmyshow.model.Movie;
import com.sukrit.bookmyshow.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieResponseDTO> addMovie(List<MovieRequestDTO> movieList) {
        List<Movie> movies = movieList.stream().map(MovieEntityDTOBuilder::toEntity).toList();

        boolean movieExist = false;
        //Check whether movie is stored in db
        for(Movie movie: movies){
            if(movieRepository.existsMovieByName(movie.getName())){
                movieExist = true;
                break;
            }
        }

        if(movieExist)
            return new ArrayList<>();
        movieRepository.saveAll(movies);
        return movies.stream().map(MovieEntityDTOBuilder::toDto).toList();
    }

    public List<MovieResponseDTO> updateMovie(List<MovieRequestDTO> movieList){
        List<Movie> movies = movieList.stream().map(MovieEntityDTOBuilder::toEntity).toList();
        movieRepository.saveAll(movies);
        return movies.stream().map(MovieEntityDTOBuilder::toDto).toList();
    }

    public MovieResponseDTO getDetails(Long movieId){
        Movie movie = null;
        movie = movieRepository.findById(movieId).get();
        return MovieEntityDTOBuilder.toDto(movie);
    }

    public List<MovieResponseDTO> getMoviesList(){
        return movieRepository.findAll().stream().map(MovieEntityDTOBuilder::toDto).toList();
    }

    public List<MovieResponseDTO> getMoviesListInPagination(int offset, int pageSize, String sortDir, String sortBy){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(offset, pageSize, sort);

        List<Movie> moviesPage = movieRepository.findAll(pageable).getContent();
        return moviesPage.stream().map(MovieEntityDTOBuilder::toDto).toList();
    }
}
