package com.kairischarm.mealdb.robots

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers.*

import com.kairischarm.mealdb.R

fun onRecipeScreen(func: RecipeRobot.() -> Unit) = RecipeRobot().apply(func)

class RecipeRobot : BaseRobot() {
    fun assertRecipeName(recipeName: String) {
        findViewWithIdAndText(R.id.recipeName, recipeName)
    }

    fun assertIngredientCount(count: Int) {
        listHasItemCount(count, R.id.ingredientsList)
    }

    fun assertIngredientAtPosition(position: Int, ingredientName: String) {
        listItemAtPositionHasText(position, ingredientName, R.id.ingredientsList, R.id.ingredientDescription)
    }

    fun assertInstructions(recipeInstructions: String) {
        findViewWithIdAndText(R.id.recipeInstructions, recipeInstructions)
    }

    fun scrollDown() {
        // ViewActions.scrollTo() is not supported for NestedScrollView
        onView(withId(R.id.recipeLayout)).perform(ViewActions.swipeUp())
    }
}