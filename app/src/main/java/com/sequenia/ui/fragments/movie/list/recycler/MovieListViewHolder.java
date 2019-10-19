package com.sequenia.ui.fragments.movie.list.recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.sequenia.R;
import com.sequenia.common.BaseViewHolder;
import com.sequenia.interfaces.Consumer;
import com.sequenia.model.response.MovieResponse;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListViewHolder extends BaseViewHolder<MovieResponse> {

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.name)
    TextView name;

    public MovieListViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    protected void initViews(@NonNull View itemView) {
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(MovieResponse movie, Consumer<MovieResponse> clickHandler) {
        super.clickHandler = clickHandler;
        super.data = movie;
        Picasso.get()
                .load(movie.getImageUrl())
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.image_not_found)
                .into(image);
        name.setText(movie.getName());
    }
}
