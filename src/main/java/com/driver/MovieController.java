package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    // 1. Add a movie
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody()Movie movie) {

        try {
            movieService.addMovie(movie);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // 2. Add a director
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody()Director director) {

        try {
            movieService.addDirector(director);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // 3. Pair an existing movie and director
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String mvName, @RequestParam("directorName") String drName){
        try{
            movieService.addMovieDirectorPair(mvName,drName);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    // 4. Get Movie by movie name
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
        return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.OK);
    }

    // 5. Get Director by director name
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name) {
        return new ResponseEntity<>(movieService.getDirectorByName(name), HttpStatus.OK);
    }

    // 6. Get List of movies name for a given director name
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director) {
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director), HttpStatus.OK);
    }


    // 7. Get List of all movies added
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String drName){
        try{
            movieService.deleteDirectorByName(drName);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        try{
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
