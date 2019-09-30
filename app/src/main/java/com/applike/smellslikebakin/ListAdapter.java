package com.applike.smellslikebakin;

/**
 * Created by omid mirrajei on 29/09/2019
 */
public class ListAdapter extends RecyclerAdapter {
    private final ListFragment.OnRecipSelectedInterface mListener;

    public ListAdapter(ListFragment.OnRecipSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onListRecipeSelected(index);
    }
}

