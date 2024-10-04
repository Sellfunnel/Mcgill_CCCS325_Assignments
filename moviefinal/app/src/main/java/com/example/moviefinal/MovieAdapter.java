package com.example.moviefinal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context context;
    private ArrayList<Movie> movies;
    private int selectedItem = -1;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
        sortAscending(); // Default sorting by ascending price
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.title.setText(movie.getTitle());
        holder.price.setText(String.format("$%.2f", movie.getPrice()));
        holder.image.setImageResource(movie.getImageID());

        holder.itemView.setSelected(selectedItem == position);
        holder.itemView.setOnClickListener(v -> {
            notifyItemChanged(selectedItem);
            selectedItem = position;
            notifyItemChanged(selectedItem);

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", movie.getTitle());
            intent.putExtra("image", movie.getImageID());
            intent.putExtra("description", movie.getDescription());
            intent.putExtra("director", movie.getDirector());
            intent.putExtra("stars", movie.getStars());
            intent.putExtra("price", movie.getPrice());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView title, price;
        ImageView image;

        MovieViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_view_title);
            price = itemView.findViewById(R.id.text_view_price);
            image = itemView.findViewById(R.id.image_view_movie);
        }
    }

    // Method to sort movies in ascending order by price
    public void sortAscending() {
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return Double.compare(m1.getPrice(), m2.getPrice());
            }
        });
        notifyDataSetChanged();
    }

    // Method to sort movies in descending order by price
    public void sortDescending() {
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return Double.compare(m2.getPrice(), m1.getPrice());
            }
        });
        notifyDataSetChanged();
    }
}