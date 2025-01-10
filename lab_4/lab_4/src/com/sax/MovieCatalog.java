package com.sax;

import java.util.ArrayList;

public class MovieCatalog {
    private ArrayList<Movie> movies;

    public MovieCatalog() {
        movies = new ArrayList<>();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie m) {
        movies.add(m);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movie m : movies) {
            sb.append(m.toString());
        }
        return sb.toString();
    }
}
