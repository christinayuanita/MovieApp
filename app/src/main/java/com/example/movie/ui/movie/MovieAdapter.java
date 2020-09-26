package com.example.movie.ui.movie;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.movie.R;
import com.example.movie.model.MovieEntity;
import com.example.movie.ui.detail.DetailMovieActivity;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieEntity> listMovies = new ArrayList<>();

    void setMovies(List<MovieEntity> listMovie){
        if(listMovie == null) return;
        listMovies.clear();
        listMovies.addAll(listMovie);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movies, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieEntity movie = listMovies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        final TextView movieTitle;
        final TextView movieDesc;
        final ImageView moviePoster;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movie_item_title);
            movieDesc = itemView.findViewById(R.id.movie_item_description);
            moviePoster = itemView.findViewById(R.id.movie_poster);
        }

        void bind(MovieEntity movie){
            movieTitle.setText(movie.getMovieName());
            movieDesc.setText(movie.getMovieDesc());
            itemView.setOnClickListener(v -> {
                Intent i = new Intent(itemView.getContext(), DetailMovieActivity.class);
                i.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie);
                itemView.getContext().startActivity(i);
            });
            Glide.with(itemView.getContext())
                    .load(movie.getMovieImg())
                    .into(moviePoster);
        }
    }
}
