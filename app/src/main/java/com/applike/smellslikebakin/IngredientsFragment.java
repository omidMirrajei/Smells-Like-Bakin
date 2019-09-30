package com.applike.smellslikebakin;

/**
 * Created by omid mirrajei on 29/09/2019
 */
public class IngredientsFragment extends CheckBoxesFragment{
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
