package com.example.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MoviesListFragment extends Fragment {
    private RecyclerView recyclerView;
    private MyItemRecyclerViewAdapter adapter;
    private List<String> movieNames = new ArrayList<>();

    public interface OnMovieClickListener {
        void onMovieClick(String movie);
    }

    public MoviesListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);
        recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new MyItemRecyclerViewAdapter(movieNames, this::onMovieClicked);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void onMovieClicked(String movie) {
    }

    public void updateMovieList(List<String> movies) {
        adapter.updateMovies(movies);
    }
}
