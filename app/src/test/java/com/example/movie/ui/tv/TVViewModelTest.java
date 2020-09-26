package com.example.movie.ui.tv;

import com.example.movie.model.TVEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TVViewModelTest {

    private TVViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new TVViewModel();
    }

    @Test
    public void getShows() {
        List<TVEntity> tvEntities = viewModel.getShows();
        assertNotNull(tvEntities);
        assertEquals(10, tvEntities.size());
    }
}