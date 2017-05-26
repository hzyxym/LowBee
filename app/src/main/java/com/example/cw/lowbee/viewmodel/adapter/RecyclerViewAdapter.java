package com.example.cw.lowbee.viewmodel.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * Created by cw on 2017/5/26.
 */

public class RecyclerViewAdapter<T> extends BindingRecyclerViewAdapter<T> {
    @Override
    public ViewDataBinding onCreateBinding(LayoutInflater inflater, @LayoutRes int layoutId, ViewGroup viewGroup) {
        ViewDataBinding binding = super.onCreateBinding(inflater, layoutId, viewGroup);
        return binding;
    }

    @Override
    public void onBindBinding(ViewDataBinding binding, int variableId, @LayoutRes int layoutRes, int position, T item) {
        super.onBindBinding(binding, variableId, layoutRes, position, item);
    }
}
