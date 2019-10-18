package com.sequenia.repositories.network;

import com.sequenia.model.response.MovieResponseCallback;
import com.sequenia.repositories.Repository;

public interface NetworkRepository extends Repository {
    void query(MovieResponseCallback callback);
}
