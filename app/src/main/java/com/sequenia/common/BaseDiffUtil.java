package com.sequenia.common;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public abstract class BaseDiffUtil<T> extends DiffUtil.Callback {
    protected final List<T> oldList;
    protected final List<T> newList;

    public BaseDiffUtil(List<T> oldList, List<T> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }
}
