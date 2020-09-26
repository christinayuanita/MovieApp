package com.example.movie.ui.detail;

import androidx.lifecycle.ViewModel;

import com.example.movie.model.MovieEntity;
import com.example.movie.utils.DataDummy;

import java.util.ArrayList;
import java.util.List;

public class DetailMovieViewModel extends ViewModel {

    private MovieEntity movie;

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public MovieEntity getMovie(){
        MovieEntity selectedMovie = null;
        List<MovieEntity> movieEntities = DataDummy.generateDummyMovies();
        for (MovieEntity movieEntity : movieEntities) {
            if(movieEntity.getMovieName().equals(movie.getMovieName()))
                selectedMovie = movieEntity;
        }
        return selectedMovie;
    }



}
