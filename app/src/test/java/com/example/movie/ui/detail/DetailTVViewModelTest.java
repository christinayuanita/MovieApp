package com.example.movie.ui.detail;

import com.example.movie.model.MovieEntity;
import com.example.movie.model.TVEntity;
import com.example.movie.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailTVViewModelTest {

    private DetailTVViewModel viewModel;
    private TVEntity dummyMovie;

    @Before
    public void setUp() {
        viewModel = new DetailTVViewModel();
        dummyMovie = DataDummy.generateDummyTVShows().get(0);
        viewModel.setTV(dummyMovie);
    }

    @Test
    public void getTV() {

        viewModel.setTV(dummyMovie);
        TVEntity movieEntity = viewModel.getTV();
        assertNotNull(movieEntity);
        assertEquals(dummyMovie.getTvName(), movieEntity.getTvName());
        assertEquals(dummyMovie.getTvDesc(), movieEntity.getTvDesc());
        assertEquals(dummyMovie.getTvGenre(), movieEntity.getTvGenre());
        assertEquals(dummyMovie.getTvImg(), movieEntity.getTvImg());
    }
}