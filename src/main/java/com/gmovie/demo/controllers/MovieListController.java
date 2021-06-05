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

//    @GetMapping(value = "/gmdb/movies/{id}")
//    public User Get(@PathVariable int id) {
//        return userService.Get(id);
//    }
}