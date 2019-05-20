package com.kairischarm.mealdb.dataproviders

import com.kairischarm.mealdb.recipe.Recipe
import com.kairischarm.mealdb.recipe.RecipeMetadata
import com.kairischarm.mealdb.recipe.categories.Category

import io.reactivex.Observable

interface DataProvider {
    fun getCategories(): Observable<List<Category>>
    fun getRecipesMetadata(categoryName: String): Observable<List<RecipeMetadata>>
    fun getRecipe(recipeId: Int): Observable<Recipe>
}