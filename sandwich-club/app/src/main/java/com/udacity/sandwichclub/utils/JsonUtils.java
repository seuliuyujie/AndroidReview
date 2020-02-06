package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String TAG = "JsonUtils";

    private static final String SANDWICH_NAME = "name";
    private static final String SANDWICH_MAIN_NAME = "mainName";
    private static final String SANDWICH_AKA = "alsoKnownAs";
    private static final String SANDWICH_ORIGIN = "placeOfOrigin";
    private static final String SANDWICH_DESCRIPTION = "description";
    private static final String SANDWICH_IMAGE = "image";
    private static final String SANDWICH_INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) throws JSONException {


        try {
            JSONObject sandwichJSONObject = new JSONObject(json);
            //System.out.println(sandwichJSONObjectP);
            JSONObject sandwichJSONObjectName = new JSONObject(sandwichJSONObject.getString(SANDWICH_NAME));
            //System.out.println(sandwichJSONObject);
            String sandwichMainName = sandwichJSONObjectName.getString(SANDWICH_MAIN_NAME);
            JSONArray sandwichAlsoKnownAsArray = sandwichJSONObjectName.getJSONArray(SANDWICH_AKA);
            List<String> sandwichAlsoKnownAsList = new ArrayList<>();
            for (int i = 0; i < sandwichAlsoKnownAsArray.length(); i++) {
                sandwichAlsoKnownAsList.add(sandwichAlsoKnownAsArray.getString(i));
            }

            String sandwichPlaceOfOrigin = sandwichJSONObject.getString(SANDWICH_ORIGIN);
            String sandwichDescription = sandwichJSONObject.getString(SANDWICH_DESCRIPTION);
            String sandwichImage = sandwichJSONObject.getString(SANDWICH_IMAGE);
            JSONArray sandwichIngredientsArray = sandwichJSONObject.getJSONArray(SANDWICH_INGREDIENTS);
            List<String> sandwichIngredientsList = new ArrayList<>();
            for (int i = 0; i < sandwichIngredientsArray.length(); i++) {
                sandwichIngredientsList.add(sandwichIngredientsArray.getString(i));
            }
            Sandwich sandwich = new Sandwich(sandwichMainName, sandwichAlsoKnownAsList, sandwichPlaceOfOrigin, sandwichDescription, sandwichImage, sandwichIngredientsList);
            Log.d(TAG, "sandwich.getMainName: " + sandwich.getMainName());
            Log.d(TAG, "sandwich.getAlsoKnownAs: " + sandwich.getAlsoKnownAs());
            Log.d(TAG, "sandwich.getPlaceOfOrigin: " + sandwich.getPlaceOfOrigin());
            Log.d(TAG, "sandwich.getDescription: " + sandwich.getDescription());
            Log.d(TAG, "sandwich.getImage: " + sandwich.getImage());
            Log.d(TAG, "sandwich.getIngredients: " + sandwich.getIngredients());
            return sandwich;
        } catch (final JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
