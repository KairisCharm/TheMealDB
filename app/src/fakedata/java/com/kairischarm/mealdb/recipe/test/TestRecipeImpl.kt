package com.kairischarm.mealdb.recipe.test

import android.app.Activity

import com.kairischarm.mealdb.R
import com.kairischarm.mealdb.recipe.Recipe
import com.kairischarm.mealdb.recipe.ingredients.Ingredient
import com.kairischarm.mealdb.recipe.test.ingredients.brownies.*

class TestRecipeImpl(private val activity: Activity): TestRecipeMetadataImpl(activity), Recipe {
    override fun getInstructions(): String {
        return activity.resources.getString(R.string.brownie_instructions)
    }

    override fun getIngredients(): List<Ingredient> {
        return listOf(TestBrownieIngredient1(activity),
                      TestBrownieIngredient2(activity),
                      TestBrownieIngredient3(activity),
                      TestBrownieIngredient4(activity),
                      TestBrownieIngredient5(activity),
                      TestBrownieIngredient6(activity),
                      TestBrownieIngredient7(activity))
    }
}