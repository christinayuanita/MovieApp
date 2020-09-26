package com.example.movie.ui.tv;

import androidx.lifecycle.ViewModel;

import com.example.movie.model.TVEntity;
import com.example.movie.utils.DataDummy;

import java.util.List;

public class TVViewModel extends ViewModel {

    public List<TVEntity> getShows(){
        return DataDummy.generateDummyTVShows();
    }
}
