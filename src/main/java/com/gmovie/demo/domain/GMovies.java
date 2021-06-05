package com.gmovie.demo.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "GMovies")
public class GMovies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    private String title;
    private String director;
    private String actors;
    private int release;
    private  String description;
    private int rating;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    private  String review;

}
