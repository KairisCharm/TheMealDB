package com.kairischarm.mealdb

import com.kairischarm.mealdb.robots.onCategoryListScreen
import com.kairischarm.mealdb.robots.onRecipeListScreen
import com.kairischarm.mealdb.robots.onRecipeScreen

import org.junit.Test

class RecipeFragmentTest : BaseTest() {
    @Test
    fun testRecipeFragment() {
        onCategoryListScreen {
            selectCategory("Dessert")
        }

        onRecipeListScreen {
            selectRecipe("Brownies")
        }

        onRecipeScreen {
            assertRecipeName("Brownies")

            scrollDown()

            assertIngredientCount(7)
            assertIngredientAtPosition(0, "butter")
            assertIngredientAtPosition(1, "sugar")
            assertIngredientAtPosition(2, "cocoa")
            assertIngredientAtPosition(3, "eggs")
            assertIngredientAtPosition(4, "vanilla")
            assertIngredientAtPosition(5, "salt")
            assertIngredientAtPosition(6, "flour")

            assertInstructions("Pour into greased square pan. Bake at 350 for 30 minutes.")
        }
    }
}