package com.sequenia.async;

import android.os.AsyncTask;

import com.sequenia.model.response.MovieResponseCallback;
import com.sequenia.repositories.network.NetworkRepositoryImpl;

public class NetworkAsyncTask extends AsyncTask<MovieResponseCallback, Void, Void> {

    @Override
    protected Void doInBackground(MovieResponseCallback... movieResponseCallbacks) {
        new NetworkRepositoryImpl().query(movieResponseCallbacks[0]);
        return null;
    }
}
