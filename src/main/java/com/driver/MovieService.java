package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    // 1. Add a movie
    void addMovie(Movie movie){

        movieRepository.addMovie(movie);
    }

    // 2. Add a director
    void addDirector(Director director){

        movieRepository.addDirector(director);
    }

    // 3. Pair an existing movie and director

    void addMovieDirectorPair(String mvName, String drName){
        movieRepository.addMovieDirectorPair(mvName,drName);
    }

    // 4. Get Movie by movie name

    Movie getMovieByName(String name){
       return movieRepository.getMovieByName(name);
    }

    // 5. Get Director by director name

    Director getDirectorByName(String name){
        return movieRepository.getDirectorByName(name);
    }

    // 6. Get List of movies name for a given director name

    List<String> getMoviesByDirectorName(String name){
        //System.out.println("in service");
        return movieRepository.getMoviesByDirectorName(name);
    }

    // 7. Get List of all movies added
    List<String> findAllMovies(){

        return movieRepository.findAllMovies();
    }

    void deleteDirectorByName(String name){
        movieRepository.deleteDirectorByName(name);
    }

    void deleteAllDirectors(){

        movieRepository.deleteAllDirectors();
    }

}
