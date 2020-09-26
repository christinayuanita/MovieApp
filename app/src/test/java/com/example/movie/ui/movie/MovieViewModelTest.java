package com.example.movie.ui.movie;

import com.example.movie.model.MovieEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieViewModelTest {

    private MovieViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new MovieViewModel();
    }

    @Test
    public void getMovies() {
        List<MovieEntity> movieEntities = viewModel.getMovies();
        assertNotNull(movieEntities);
        assertEquals(10, movieEntities.size());
    }
}