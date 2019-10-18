package com.sequenia.model.response;

import androidx.annotation.NonNull;

import java.util.List;

public interface MovieResponseCallback extends ResponseCallback<List<MovieResponse>> {
    @Override
    void onSuccess(List<MovieResponse> response);

    @Override
    void onError(@NonNull Throwable throwable);
}
