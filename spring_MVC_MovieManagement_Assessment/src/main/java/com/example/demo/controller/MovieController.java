package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // View all movies
    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "Movie_list";
    }

    // Show add form
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "Movie_form";
    }

    // Save movie
    @PostMapping
    public String saveMovie(@ModelAttribute Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "Movie_form";
    }

    // Delete movie
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}