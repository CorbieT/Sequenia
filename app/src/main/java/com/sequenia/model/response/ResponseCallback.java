package com.sequenia.model.response;

import androidx.annotation.NonNull;

public interface ResponseCallback<T> {
    void onSuccess(T response);

    void onError(@NonNull Throwable throwable);
}
