package com.driver;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MovieRepository {
    HashMap<String,Movie> movies = new HashMap<>();
    HashMap<String,Director> directors = new HashMap<>();

    HashMap<String,String> mvd = new HashMap<>();

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
        mvd.put(mvName,drName);
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
        //System.out.println("in repo" + " "+ name);
        List<String> movieNamesList = new ArrayList<>();
        for(Map.Entry<String, String> entry: mvd.entrySet()) {
            //System.out.println(entry.getValue());
            if(entry.getValue().equals(name)) {
                //System.out.println("if");
                movieNamesList.add(entry.getKey());
            }
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
        for (Map.Entry<String,String> mapElement : mvd.entrySet()){
            if(mapElement.getValue().equals(name)) {
                movies.remove(mapElement.getKey());
                mvd.remove(mapElement.getKey());
            }
        }
        for(Director director:directors.values()){
            if(director.getName().equals(name)){
                directors.remove(name);
            }
        }

    }
    void deleteAllDirectors(){
        HashSet<String> movieSet = new HashSet<>();
            for (Map.Entry<String,String> mapElement : mvd.entrySet()){
                    movieSet.add(mapElement.getKey());
//                    mvd.remove(mapElement.getKey());
                }
            for(String mv : movieSet){
                if(movies.containsKey(mv)){
                    movies.remove(mv);
                }
            }
//        HashMap<String,Director> directors = new HashMap<>();
    }

}
