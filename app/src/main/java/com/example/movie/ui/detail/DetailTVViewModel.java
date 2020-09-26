package com.example.movie.ui.detail;

import androidx.lifecycle.ViewModel;

import com.example.movie.model.MovieEntity;
import com.example.movie.model.TVEntity;
import com.example.movie.utils.DataDummy;

import java.util.List;

public class DetailTVViewModel extends ViewModel {

    private TVEntity tv;

    public void setTV(TVEntity tv) {
        this.tv = tv;
    }

    public TVEntity getTV(){
        TVEntity selectedMovie = null;
        List<TVEntity> movieEntities = DataDummy.generateDummyTVShows();
        for (TVEntity movieEntity : movieEntities) {
            if(movieEntity.getTvName().equals(tv.getTvName()))
                selectedMovie = movieEntity;
        }
        return selectedMovie;
    }

}
