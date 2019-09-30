package com.applike.smellslikebakin;

/**
 * Created by omid mirrajei on 30/09/2019
 */
public class GridAdapter extends RecyclerAdapter {
    private final GridFragment.OnRecipSelectedInterface mListener;

    public GridAdapter(GridFragment.OnRecipSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onGridRecipeSelected(index);
    }
}
