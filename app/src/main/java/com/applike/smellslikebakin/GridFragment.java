package com.applike.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by omid mirrajei on 30/09/2019
 */
public class GridFragment extends Fragment {

    public interface OnRecipSelectedInterface {
        void onGridRecipeSelected(int index);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        OnRecipSelectedInterface listener = (OnRecipSelectedInterface) getActivity();
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.list_recycler_view);
        GridAdapter gridAdapter = new GridAdapter(listener);
        recyclerView.setAdapter(gridAdapter);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int numColumns = (int) (dpWidth / 200);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), numColumns);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
