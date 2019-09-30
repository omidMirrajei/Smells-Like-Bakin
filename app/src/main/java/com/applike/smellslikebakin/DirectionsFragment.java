package com.applike.smellslikebakin;

/**
 * Created by omid mirrajei on 29/09/2019
 */
public class DirectionsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}
