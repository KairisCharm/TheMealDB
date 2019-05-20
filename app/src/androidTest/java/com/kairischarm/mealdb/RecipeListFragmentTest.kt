package com.kairischarm.mealdb

import com.kairischarm.mealdb.robots.onCategoryListScreen
import com.kairischarm.mealdb.robots.onRecipeListScreen

import org.junit.Test

class RecipeListFragmentTest: BaseTest() {
    @Test
    fun testRecipeListFragment() {
        onCategoryListScreen {
            selectCategory("Dessert")
        }

        onRecipeListScreen {
            assertRecipeIsVisible("Brownies")
            assertListHasItemCount(1)
        }
    }
}