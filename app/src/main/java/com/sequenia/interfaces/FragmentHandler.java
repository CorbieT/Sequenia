package com.sequenia.interfaces;

import androidx.fragment.app.Fragment;

public interface FragmentHandler {
    void createFragment(Fragment fragment);
    void createFragmentWithBackStack(Fragment fragment, String tag);
}
