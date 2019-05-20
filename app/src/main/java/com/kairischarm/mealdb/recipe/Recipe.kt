package com.kairischarm.mealdb.recipe

import com.kairischarm.mealdb.recipe.ingredients.Ingredient

interface Recipe: RecipeMetadata {
    fun getInstructions(): String
    fun getIngredients(): List<Ingredient>
}