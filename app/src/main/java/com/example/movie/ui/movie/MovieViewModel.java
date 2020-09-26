package com.example.movie.ui.movie;

import androidx.lifecycle.ViewModel;

import com.example.movie.model.MovieEntity;
import com.example.movie.utils.DataDummy;

import java.util.List;

public class MovieViewModel extends ViewModel {

    public List<MovieEntity> getMovies(){
        return DataDummy.generateDummyMovies();
    }
}
