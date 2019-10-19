package com.sequenia.ui.fragments.movie.info;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.sequenia.R;
import com.sequenia.model.response.MovieResponse;
import com.sequenia.ui.activities.MainActivity;
import com.sequenia.ui.fragments.BaseFragment;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MovieInfoFragment extends BaseFragment implements MovieInfoContract.View<MovieResponse> {

    static final String movieKey = "movie";

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.year)
    TextView year;

    @BindView(R.id.rating)
    TextView rating;

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.appbar)
    AppBarLayout appBar;

    private Unbinder unbinder;

    @Inject
    MovieInfoContract.Presenter presenter;

    public static MovieInfoFragment newInstance(MovieResponse movie) {
        Bundle args = new Bundle();
        args.putParcelable(movieKey, movie);
        MovieInfoFragment fragment = new MovieInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_info;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new MovieInfoPresenter(this);
        unbinder = ButterKnife.bind(this, view);
        ((MainActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("");
        presenter.loadBundle(this.getArguments());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void updatePageInfo(MovieResponse movieResponse) {
        presenter.loadImage(movieResponse.getImageUrl(), image);
        name.setText(movieResponse.getName());
        year.setText(getString(R.string.year, movieResponse.getYear()));
        rating.setText(getString(R.string.rating, String.valueOf(movieResponse.getRating())));
        if (movieResponse.getDescription() == null || movieResponse.getDescription().isEmpty()) {
            description.setText(getString(R.string.empty_description));
        } else {
            description.setText(movieResponse.getDescription());
        }

        setupAppBar(movieResponse);
    }

    private void setupAppBar(MovieResponse movieResponse) {
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.rgb(255, 255, 255));
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(movieResponse.getLocalizedName());

                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}
