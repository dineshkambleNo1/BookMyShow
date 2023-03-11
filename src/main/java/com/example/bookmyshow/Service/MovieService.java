package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.Movies;
import com.example.bookmyshow.Repository.MovieRepository;
import com.example.bookmyshow.RequestDto.MovieRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieRequestDto movieRequestDto){

        Movies movies = Movies.builder().name(movieRequestDto.getName()).releaseDate(movieRequestDto.getReleaseDate()).duration(movieRequestDto.getDuration()).build();
        movieRepository.save(movies);

        return "Movie added";
    }

}
