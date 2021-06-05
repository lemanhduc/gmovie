package com.gmovie.demo.controllers;

import com.gmovie.demo.domain.GMovies;
import com.gmovie.demo.repositories.GmovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieListController {


    private final GmovieRepository _movieRepository;

    @Autowired
    public MovieListController(GmovieRepository movieRepository) {
        this._movieRepository = movieRepository;
    }

    @GetMapping(value = "/gmdb/movies")
    public List<GMovies> Get() {
        List<GMovies> listMovies = new ArrayList<GMovies>();
        this._movieRepository.findAll().forEach(listMovies::add);
        return listMovies;
    }

    @PostMapping(value = "/gmdb/movies")
    public GMovies Post(@RequestBody GMovies params) {

        return this._movieRepository.save(params);
    }

    @GetMapping(value = "/gmdb/{id}")
    public GMovies Get(@PathVariable int id) {
        return this._movieRepository.findById(id).get();
    }

    @GetMapping(value = "/gmdb/title/{title}")
    public GMovies Get(@PathVariable String title) {
        GMovies result = this._movieRepository.findByTitle(title);
        if (result == null) {
            GMovies response = new GMovies();
            response.setDescription("does not exist");
            return response;
        }
        return result;
    }

    @PatchMapping("/rating/{movieRating}/{review}/{id}")
    public GMovies create(@PathVariable int movieRating, @PathVariable String review, @PathVariable int id) {
        GMovies movie = this._movieRepository.findById(id).get();
        if (movieRating == 0) {
            movie.setDescription("Rating is required with Review");
            return movie;
        }
        else {
            movie.setReview(review);
            movie.setRating(movieRating);
            return this._movieRepository.save(movie);
        }
    }




}