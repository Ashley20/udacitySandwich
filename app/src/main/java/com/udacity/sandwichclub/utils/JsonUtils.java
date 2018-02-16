package com.udacity.sandwichclub.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        final JSONObject jsonObject = new JSONObject(json);
        final JSONObject nameObject  = jsonObject.getJSONObject("name");
        final JSONArray  alsoKnownAsArray = nameObject.getJSONArray("alsoKnownAs");
        final JSONArray  ingredientsArray = jsonObject.getJSONArray("ingredients");


        /* Get specific fields from the json object like mainName,
         image, description, placeOfOrigin, alsoKnownAs and ingredients
         */
        String placeOfOrigin = jsonObject.getString("placeOfOrigin");
        String description = jsonObject.getString("description");
        String image = jsonObject.getString("image");
        String mainName = nameObject.getString("mainName");

        List<String> alsoKnownAs = new ArrayList<>();
        List<String> ingredients = new ArrayList<>();
        final int n = alsoKnownAsArray.length();
        final int m = ingredientsArray.length();


        for(int i = 0 ; i < n; i++){
            alsoKnownAs.add(alsoKnownAsArray.getString(i));
        }

        for(int i = 0 ; i < m; i++){
            ingredients.add(ingredientsArray.getString(i));
        }

        // Return a brand new Sandwich object filled with data we parsed from json string
        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

    }
}
