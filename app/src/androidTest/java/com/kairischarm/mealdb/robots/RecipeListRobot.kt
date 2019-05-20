package com.kairischarm.mealdb.robots

import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers

import com.kairischarm.mealdb.R

fun onRecipeListScreen(func: RecipeListRobot.() -> Unit) = RecipeListRobot().apply(func)

class RecipeListRobot: BaseRobot() {
    fun assertRecipeIsVisible(categoryName: String) {
        findRecipeWithName(categoryName).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun assertListHasItemCount(count: Int) {
        listHasItemCount(count, R.id.recyclerView)
    }

    fun selectRecipe(categoryName: String) {
        click(findRecipeWithName(categoryName))
    }

    private fun findRecipeWithName(recipeName: String): ViewInteraction {
        return findViewWithIdAndText(R.id.recipeName, recipeName)
    }
}