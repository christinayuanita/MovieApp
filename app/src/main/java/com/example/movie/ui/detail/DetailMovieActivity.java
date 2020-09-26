package com.example.movie.ui.detail;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.movie.R;
import com.example.movie.model.MovieEntity;
import com.example.movie.ui.movie.MovieViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView title, description, genre;
    private ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        title = findViewById(R.id.movie_title);
        description = findViewById(R.id.movie_desc);
        genre = findViewById(R.id.movie_genre);
        poster = findViewById(R.id.movie_poster);

        DetailMovieViewModel detailMovieViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailMovieViewModel.class);
        detailMovieViewModel.setMovie(getIntent().getParcelableExtra(EXTRA_MOVIE));
        MovieEntity movie = detailMovieViewModel.getMovie();
        title.setText(movie.getMovieName());
        description.setText(movie.getMovieDesc());
        genre.setText(movie.getMovieGenre());

        Glide.with(this)
                .load(movie.getMovieImg())
                .into(poster);


    }
}