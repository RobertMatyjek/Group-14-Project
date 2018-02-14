package com.example.andrewratz.recipeasedatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andrewratz on 2/13/18.
 */

public class Recipe {
    public String id;
    public List<String> ingredients = new ArrayList<>();

    public Recipe() {

    }

    public Recipe(String id, String[] ingredients) {
        this.id = id;
        this.ingredients = Arrays.asList(ingredients);
    }
}
