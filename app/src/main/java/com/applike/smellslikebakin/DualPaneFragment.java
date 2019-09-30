package com.applike.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by omid mirrajei on 30/09/2019
 */
public class DualPaneFragment extends Fragment {

    private static final String INGREDIENT_FRAGMENT = "ingredients_fragment";
    private static final String DIRECTIONS_FRAGMENT = "directions_fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);
        View view = inflater.inflate(R.layout.fragment_dualpane, container, false);

        FragmentManager fragmentManager = getChildFragmentManager();

        IngredientsFragment SavedIngredientsFragment = (IngredientsFragment) fragmentManager
                .findFragmentByTag(INGREDIENT_FRAGMENT);
        if (SavedIngredientsFragment == null) {
            IngredientsFragment ingredientsFragment = new IngredientsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
            ingredientsFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .add(R.id.left_place_holder, ingredientsFragment, INGREDIENT_FRAGMENT)
                    .commit();
        }

        DirectionsFragment SavedDirectionsFragment = (DirectionsFragment) fragmentManager
                .findFragmentByTag(DIRECTIONS_FRAGMENT);
        if (SavedDirectionsFragment == null) {
            DirectionsFragment directionsFragment = new DirectionsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
            directionsFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .add(R.id.right_place_holder, directionsFragment, DIRECTIONS_FRAGMENT)
                    .commit();
        }

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
