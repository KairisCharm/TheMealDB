package com.kairischarm.mealdb.recipe

interface RecipeSelectedListener {
    @Throws(IllegalAccessException::class)
    fun recipeSelected(recipe: RecipeMetadata)
}