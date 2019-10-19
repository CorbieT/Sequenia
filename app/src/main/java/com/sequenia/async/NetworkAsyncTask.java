package com.sequenia.async;

import android.os.AsyncTask;

import com.sequenia.model.response.MovieResponseCallback;
import com.sequenia.repositories.network.NetworkRepository;

public class NetworkAsyncTask extends AsyncTask<MovieResponseCallback, Void, Void> {
    private NetworkRepository networkRepository;

    public NetworkAsyncTask(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    protected Void doInBackground(MovieResponseCallback... movieResponseCallbacks) {
        networkRepository.query(movieResponseCallbacks[0]);
        return null;
    }
}
