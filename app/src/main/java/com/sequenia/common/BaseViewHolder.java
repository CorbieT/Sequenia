package com.sequenia.common;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sequenia.interfaces.Consumer;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected Consumer<T> clickHandler;

    protected T data;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
        itemView.setOnClickListener(this);
    }

    protected abstract void initViews(@NonNull View itemView);

    public abstract void bind(T data, Consumer<T> clickHandler);

    @Override
    public void onClick(View view) {
        clickHandler.apply(data);
    }
}
