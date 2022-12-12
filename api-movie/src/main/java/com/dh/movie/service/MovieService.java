package com.dh.movie.service;


import com.dh.movie.event.NewMovieEventProducer;
import com.dh.movie.model.Movie;
import com.dh.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    private final MovieRepository movieRepository;

    private final NewMovieEventProducer movieEventProducer;

    public MovieService(MovieRepository movieRepository, NewMovieEventProducer movieEventProducer) {
        this.movieRepository = movieRepository;
        this.movieEventProducer = movieEventProducer;
    }

    public Movie save(Movie movie) {
        Movie movieSaved = movieRepository.save(movie);
        movieEventProducer.execute(movieSaved);
        return movie;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie getById(Long id){
        return movieRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    /*public void update(Movie movie) {
        if(movieRepository.existsById(movie.getId())) {
            movieRepository.save(movie);
        }
    }*/

    public List<Movie> findByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }


}
