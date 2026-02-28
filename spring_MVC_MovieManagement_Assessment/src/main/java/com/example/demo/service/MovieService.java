package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    
    public MovieService(MovieRepository mr) {
    		this.movieRepository = mr;
    }

    // Save Movie (Create)
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Get All Movies (Read)
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Get Movie By ID
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    // Update Movie
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Delete Movie
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}