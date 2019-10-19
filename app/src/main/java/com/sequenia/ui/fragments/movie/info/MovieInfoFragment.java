package com.sequenia.ui.fragments.movie.info;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.sequenia.R;
import com.sequenia.model.response.MovieResponse;
import com.sequenia.ui.activities.MainActivity;
import com.sequenia.ui.fragments.BaseFragment;

import java.util.Objects;


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

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Unbinder unbinder;

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

        presenter.loadBundle(this.getArguments());


//        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
//        collapsingToolbarLayout.setTitle("Create Delivery Personnel");
//        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
//        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.rgb(0, 0, 0));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void updatePageInfo(MovieResponse movieResponse) {
        name.setText("" + movieResponse.getName());
        year.setText("Год:" + movieResponse.getYear());
        rating.setText("" + movieResponse.getRating());
        description.setText(movieResponse.getDescription());
        toolbar.setTitle(movieResponse.getLocalizedName());
    }
}
