package com.sequenia.interfaces;

@FunctionalInterface
public interface Consumer<T> {
    void apply(T data);
}
