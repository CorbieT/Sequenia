package com.sequenia.ui.fragments.movie.info;

import android.os.Bundle;

public interface MovieInfoContract {
    interface View<T> {
        void updatePageInfo(T t);
    }

    interface Presenter {
        void loadBundle(Bundle bundle);
    }
}
