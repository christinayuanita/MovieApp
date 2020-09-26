package com.example.movie.ui.tv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.movie.R;
import com.example.movie.model.MovieEntity;
import com.example.movie.model.TVEntity;
import com.example.movie.ui.movie.MovieAdapter;
import com.example.movie.utils.DataDummy;

import java.util.List;

public class TVFragment extends Fragment {

    private RecyclerView rvMovie;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_t_v, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_tvShow);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity() != null){
            TVViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TVViewModel.class);
            List<TVEntity> tv = viewModel.getShows();

            TVAdapter tvAdapter = new TVAdapter();
            tvAdapter.setTV(tv);

            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(tvAdapter);
        }
    }
}