package com.example.movie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private List<String> mValues;
    private final MoviesListFragment.OnMovieClickListener mListener;

    public MyItemRecyclerViewAdapter(List<String> items, MoviesListFragment.OnMovieClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_movies_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String item = mValues.get(position);
        holder.mContentView.setText(item);
        holder.itemView.setOnClickListener(v -> mListener.onMovieClick(item));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void updateMovies(List<String> movies) {
        mValues = movies;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            mContentView = view.findViewById(R.id.text_view);
        }
    }
}
