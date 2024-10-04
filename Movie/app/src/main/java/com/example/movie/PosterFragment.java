package com.example.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;

public class PosterFragment extends Fragment implements Updateable {

    private static final String ARG_MOVIE_KEY = "movie_key";
    private String movieKey;

    public static PosterFragment newInstance(String movieKey) {
        PosterFragment fragment = new PosterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_MOVIE_KEY, movieKey);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_poster, container, false);
        if (getArguments() != null) {
            movieKey = getArguments().getString(ARG_MOVIE_KEY);
        }
        ImageView posterImage = view.findViewById(R.id.poster_image);
        int imageResId = getImageResource(movieKey);
        posterImage.setImageResource(imageResId);
        return view;
    }

    private int getImageResource(String movieKey) {
        if (movieKey == null) return R.drawable.default_image;
        switch (movieKey.toLowerCase()) {
            case "comedy": return R.drawable.comedy_poster;
            case "horror": return R.drawable.horror_poster;
            case "romance": return R.drawable.romance_poster;
            default: return R.drawable.default_image;
        }
    }

    @Override
    public void updateContent(String genre) {
        if (getView() != null && genre != null) {
            ImageView posterImage = getView().findViewById(R.id.poster_image);
            int imageResId = getImageResource(genre);
            posterImage.setImageResource(imageResId);
        }
    }
}
