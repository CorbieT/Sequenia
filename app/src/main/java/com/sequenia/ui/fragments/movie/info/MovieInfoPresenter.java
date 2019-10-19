package com.sequenia.ui.fragments.movie.info;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;

import com.sequenia.R;
import com.sequenia.model.response.MovieResponse;
import com.squareup.picasso.Picasso;


import static com.sequenia.ui.fragments.movie.info.MovieInfoFragment.movieKey;

public class MovieInfoPresenter implements MovieInfoContract.Presenter {

    private MovieInfoContract.View<MovieResponse> view;
    private MovieResponse movie;

    public MovieInfoPresenter(MovieInfoContract.View<MovieResponse> view) {
        this.view = view;
    }

    @Override
    public void loadBundle(Bundle bundle) {
        if (bundle != null) {
            movie = bundle.getParcelable(movieKey);
        }
        view.updatePageInfo(movie);
    }

    @Override
    public void loadImage(String imageUrl, ImageView targetView) {
        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.image_not_found)
                .resize(460, 400)
                .centerCrop(Gravity.CENTER)
                .into(targetView);
    }
}
