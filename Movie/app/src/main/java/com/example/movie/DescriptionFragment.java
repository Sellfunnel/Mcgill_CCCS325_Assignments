package com.example.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class DescriptionFragment extends Fragment implements Updateable {

    private static final String ARG_GENRE = "genre";
    private String genre;

    public static DescriptionFragment newInstance(String genre) {
        DescriptionFragment fragment = new DescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_GENRE, genre);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        if (getArguments() != null) {
            genre = getArguments().getString(ARG_GENRE);
        }
        TextView descriptionText = view.findViewById(R.id.description_text);
        descriptionText.setText("Description for " + genre);
        return view;
    }

    @Override
    public void updateContent(String genre) {
        if (getView() != null && genre != null) {
            TextView descriptionText = getView().findViewById(R.id.description_text);
            descriptionText.setText("Updated Description for " + genre);
        }
    }
}
