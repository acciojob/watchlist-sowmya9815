package com.driver;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MovieRepository {
    HashMap<String,Movie> movies = new HashMap<>();
    HashMap<String,Director> directors = new HashMap<>();

    HashMap<String,List<String>> mvd = new HashMap<>();

    // 1. Add a movie
    void addMovie(Movie movie){

        movies.put(movie.getName(), movie);

    }

    // 2. Add a director

    void addDirector(Director director){

        directors.put(director.getName(), director);

    }

    // 3. Pair an existing movie and director

    void addMovieDirectorPair(String mvName,String drName){
        if(movies.containsKey(mvName) && directors.containsKey(drName)){
            movies.put(mvName,movies.get(mvName));
            directors.put(drName,directors.get(drName));
            List<String> currentMovies = new ArrayList<String>();
            if (mvd.containsKey(drName)) currentMovies=mvd.get(drName);
            currentMovies.add(mvName);
            mvd.put(drName,currentMovies);
        }

//        mvd.put(mvName,drName);
    }

    // 4. Get Movie by movie name

    Movie getMovieByName(String name){
       return movies.get(name);
    }

    // 5. Get Director by director name
    Director getDirectorByName(String name){
        return directors.get(name);
    }

    // 6. Get List of movies name for a given director name

    List<String> getMoviesByDirectorName(String name){
        List<String> movieNamesList = new ArrayList<>();
            if(mvd.containsKey(name)) {
                //System.out.println("if");
                movieNamesList=mvd.get(name);
            }
        return movieNamesList;
    }



    // 7. Get List of all movies added
    List<String> findAllMovies(){

        List<String> movieList = new ArrayList<>();

        for(Movie movie:movies.values()){
            movieList.add(movie.getName());
        }
        return movieList;
    }

    void deleteDirectorByName(String name){
        List<String> mvs = new ArrayList<String>();
        if(mvd.containsKey(name)){
            mvs = mvd.get(name);
            for(String mv: mvs){
                if(movies.containsKey(mv)){
                    movies.remove(mv);
                }
            }

            mvd.remove(name);
        }

        if(directors.containsKey(name)){
            directors.remove(name);
        }

    }
    void deleteAllDirectors() {
        HashSet<String> moviesSet = new HashSet<>();
        for(String director: mvd.keySet()){
            for(String movie: mvd.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movies.containsKey(movie)){
                movies.remove(movie);
            }
        }
    }
}
