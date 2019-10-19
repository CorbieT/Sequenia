package com.sequenia.ui.fragments.movie.list;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sequenia.R;
import com.sequenia.common.MovieDiffUtil;
import com.sequenia.model.response.MovieResponse;
import com.sequenia.ui.fragments.BaseFragment;
import com.sequenia.ui.fragments.movie.info.MovieInfoFragment;
import com.sequenia.ui.fragments.movie.list.recycler.MovieListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MovieListFragment extends BaseFragment implements MovieListContract.View {

    private MovieListContract.Presenter presenter;

    private MovieListAdapter adapter;

    @BindView(R.id.recycler)
    RecyclerView recycler;

    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.progress)
    ProgressBar progress;

    private Unbinder unbinder;

    public static MovieListFragment newInstance() {
        return new MovieListFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_list;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new MovieListPresenter(this);
        unbinder = ButterKnife.bind(this, view);
        initRecycler(view);
        presenter.loadMovies();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initRecycler(View view) {
        recycler = view.findViewById(R.id.recycler);
        adapter = new MovieListAdapter(movieResponse -> presenter.holderClick(movieResponse));
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }

    @Override
    public void updateRecyclerData(List<MovieResponse> response) {
        MovieDiffUtil movieDiffUtil = new MovieDiffUtil(adapter.getData(), response);
        DiffUtil.DiffResult movieDiffResult = DiffUtil.calculateDiff(movieDiffUtil);
        adapter.updateItems(response);
        movieDiffResult.dispatchUpdatesTo(adapter);
    }

    @Override
    public void openMovieInfoFragment(MovieResponse movie) {
        createFragmentWithBackStack(MovieInfoFragment.newInstance(movie), "movie_info");
    }

    @Override
    public void updateSpinnerData(List<String> data) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_dropdown_item_1line, data);
        spinner.setAdapter(adapter);
        setupSpinnerListener(data);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    private void setupSpinnerListener(List<String> data) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                ((TextView) parent.getChildAt(0)).setTypeface(Typeface.DEFAULT_BOLD);
                presenter.onChooseGengre(data.get(selectedItemPosition));
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
