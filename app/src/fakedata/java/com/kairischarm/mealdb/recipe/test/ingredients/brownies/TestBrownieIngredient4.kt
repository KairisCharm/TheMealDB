package com.kairischarm.mealdb.recipe.test.ingredients.brownies

import android.app.Activity

import com.kairischarm.mealdb.R
import com.kairischarm.mealdb.recipe.ingredients.Ingredient

import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

class TestBrownieIngredient4(private val activity: Activity) : Ingredient {
    override fun getDescription(): String {
        return activity.getString(R.string.brownie_ingredient_4)
    }

    override fun getImage(): RequestCreator {
        return Picasso.get().load(R.drawable.eggs_small)
    }
}