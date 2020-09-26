package com.example.movie.ui.detail;

import com.example.movie.model.MovieEntity;
import com.example.movie.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailMovieViewModelTest {

    private DetailMovieViewModel viewModel;
    private MovieEntity dummyMovie;

    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel();
        dummyMovie = DataDummy.generateDummyMovies().get(0);
        viewModel.setMovie(dummyMovie);
    }

    @Test
    public void getMovie() {

        viewModel.setMovie(dummyMovie);
        MovieEntity movieEntity = viewModel.getMovie();
        assertNotNull(movieEntity);
        assertEquals(dummyMovie.getMovieName(), movieEntity.getMovieName());
        assertEquals(dummyMovie.getMovieDesc(), movieEntity.getMovieDesc());
        assertEquals(dummyMovie.getMovieGenre(), movieEntity.getMovieGenre());
        assertEquals(dummyMovie.getMovieImg(), movieEntity.getMovieImg());
    }
}