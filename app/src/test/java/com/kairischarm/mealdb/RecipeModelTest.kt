package com.kairischarm.mealdb

import com.kairischarm.mealdb.network.RecipeModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class RecipeModelTest {
    @Test
    fun testRecipeModelIngredientBuilder() {
        val ingredientBuilderList: ArrayList<RecipeModel.RecipeModelIngredient> = arrayListOf()

        assertEquals(0, ingredientBuilderList.size)

        RecipeModel.addIngredient(ingredientBuilderList, "1 c", "butter")

        assertEquals(1, ingredientBuilderList.size)
        assertEquals("1 c butter", ingredientBuilderList[0].getDescription())
        assertEquals("https://www.themealdb.com/images/ingredients/butter-Small.png", ingredientBuilderList[0].getImageUrl())
    }
}