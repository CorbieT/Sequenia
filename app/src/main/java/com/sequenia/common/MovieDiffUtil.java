package com.sequenia.common;

import com.sequenia.model.response.MovieResponse;

import java.util.List;

public class MovieDiffUtil extends BaseDiffUtil<MovieResponse> {

    public MovieDiffUtil(List<MovieResponse> oldList, List<MovieResponse> newList) {
        super(oldList, newList);
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        MovieResponse oldItem = oldList.get(oldItemPosition);
        MovieResponse newItem = newList.get(newItemPosition);
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        MovieResponse oldItem = oldList.get(oldItemPosition);
        MovieResponse newItem = newList.get(newItemPosition);
        return oldItem.getName().equals(newItem.getName()) ||
                oldItem.getLocalizedName().equals(newItem.getLocalizedName());
    }
}
