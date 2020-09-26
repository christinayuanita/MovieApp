package com.example.movie.ui.detail;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.movie.model.MovieEntity;
import com.example.movie.model.TVEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movie.R;

public class DetailTVActivity extends AppCompatActivity {

    public static final String EXTRA_TV = "extra_tv";
    private TextView title, description, genre;
    private ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_t_v);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        title = findViewById(R.id.movie_title);
        description = findViewById(R.id.movie_desc);
        genre = findViewById(R.id.movie_genre);
        poster = findViewById(R.id.movie_poster);

        DetailTVViewModel detailTVViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailTVViewModel.class);
        detailTVViewModel.setTV(getIntent().getParcelableExtra(EXTRA_TV));
        TVEntity tv = detailTVViewModel.getTV();

        title.setText(tv.getTvName());
        description.setText(tv.getTvDesc());
        genre.setText(tv.getTvGenre());
        Glide.with(this)
                .load(tv.getTvImg())
                .into(poster);
    }
}