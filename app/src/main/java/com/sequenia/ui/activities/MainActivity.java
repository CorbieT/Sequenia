package com.sequenia.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.sequenia.R;
import com.sequenia.interfaces.FragmentHandler;
import com.sequenia.ui.fragments.movie.list.MovieListFragment;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements FragmentHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createFragment(MovieListFragment.newInstance());
    }

    @Override
    public void createFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public void createFragmentWithBackStack(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .addToBackStack(tag)
                .commit();
    }
}
