package com.sequenia.ui.fragments.movie.list;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sequenia.R;
import com.sequenia.model.response.MovieResponse;
import com.sequenia.ui.fragments.BaseFragment;
import com.sequenia.ui.fragments.movie.info.MovieInfoFragment;
import com.sequenia.ui.fragments.movie.list.recycler.MovieListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

public class MovieListFragment extends BaseFragment implements MovieListContract.View {

    @Inject
    MovieListContract.Presenter presenter;

    private MovieListAdapter adapter;

    @BindView(R.id.recycler)
    RecyclerView recycler;

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
    public void updateData(List<MovieResponse> response) {
        for (MovieResponse movie : response) {
            Log.d("debug", movie.getName());
            adapter.updateItems(response);
        }
    }

    @Override
    public void openMovieInfoFragment(MovieResponse movie) {
        createFragmentWithBackStack(MovieInfoFragment.newInstance(movie), "movie_info");
    }
}
