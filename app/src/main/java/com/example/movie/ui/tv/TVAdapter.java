package com.example.movie.ui.tv;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie.R;
import com.example.movie.model.MovieEntity;
import com.example.movie.model.TVEntity;
import com.example.movie.ui.detail.DetailMovieActivity;
import com.example.movie.ui.detail.DetailTVActivity;
import com.example.movie.ui.movie.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

public class TVAdapter extends RecyclerView.Adapter<TVAdapter.TVViewHolder> {

    private List<TVEntity> listTV = new ArrayList<>();

    void setTV(List<TVEntity> listTVs){
        if(listTVs == null) return;
        listTV.clear();
        listTV.addAll(listTVs);
    }

    @NonNull
    @Override
    public TVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movies, parent, false);
        return new TVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TVViewHolder holder, int position) {
        TVEntity tv = listTV.get(position);
        holder.bind(tv);
    }

    @Override
    public int getItemCount() {
        return listTV.size();
    }

    public class TVViewHolder extends RecyclerView.ViewHolder {

        final TextView tvTitle;
        final TextView tvDesc;
        final ImageView tvPoster;

        public TVViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.movie_item_title);
            tvDesc = itemView.findViewById(R.id.movie_item_description);
            tvPoster = itemView.findViewById(R.id.movie_poster);
        }

        void bind(TVEntity tv){
            tvTitle.setText(tv.getTvName());
            tvDesc.setText(tv.getTvDesc());
            itemView.setOnClickListener(v -> {
                Intent i = new Intent(itemView.getContext(), DetailTVActivity.class);
                i.putExtra(DetailTVActivity.EXTRA_TV, tv);
                itemView.getContext().startActivity(i);
            });
            Glide.with(itemView.getContext())
                    .load(tv.getTvImg())
                    .into(tvPoster);
        }
    }
}
