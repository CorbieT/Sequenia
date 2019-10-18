package com.sequenia.ui.fragments.movie.list.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sequenia.interfaces.Consumer;
import com.sequenia.R;
import com.sequenia.common.BaseViewHolder;
import com.sequenia.model.response.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<BaseViewHolder<MovieResponse>> {

    private Consumer<MovieResponse> consumer;

    public MovieListAdapter(Consumer<MovieResponse> consumer) {
        this.consumer = consumer;
    }

    private List<MovieResponse> movieList = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder<MovieResponse> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<MovieResponse> holder, int position) {
        holder.bind(movieList.get(position), consumer);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void updateItems(List<MovieResponse> items) {
        this.movieList.clear();
        this.movieList.addAll(items);
        notifyDataSetChanged();
    }
}
