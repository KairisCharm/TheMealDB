package com.kairischarm.mealdb.network

import com.kairischarm.mealdb.dataproviders.DataProvider
import com.kairischarm.mealdb.recipe.Recipe
import com.kairischarm.mealdb.recipe.RecipeMetadata
import com.kairischarm.mealdb.recipe.categories.Category

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Handles calls to remote TheMealDB API
 *
 */
class Api: DataProvider {
    private val mealDBService = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
        .create(TheMealDBService::class.java)

    /**
     * Returns [Observable] to contents of live category data as a list of [Category]
     *
     * @return Observable to list of meal categories
     */
    override fun getCategories(): Observable<List<Category>> {
        return mealDBService.getCategories().map { it.categories }
    }

    /**
     * Returns [Observable] to contents of live recipe data for a given categoryName as a list of [RecipeMetadata]
     *
     * @param categoryName
     * @return
     */
    override fun getRecipesMetadata(categoryName: String): Observable<List<RecipeMetadata>> {
        return mealDBService.getRecipeMetadata(categoryName).map { it.meals }
    }

    /**
     * Returns [Observable] to contents of live recipe data for a given recipeId as a [Recipe]
     *
     * @param recipeId
     * @return
     */
    override fun getRecipe(recipeId: Int): Observable<Recipe> {
        return mealDBService.getRecipeDetails(recipeId).map { it.meals?.first() }
    }

    private interface TheMealDBService {
        @GET("categories.php")
        fun getCategories(): Observable<CategoryListModel>

        @GET("filter.php")
        fun getRecipeMetadata(@Query("c") categoryName: String): Observable<RecipeMetadataListModel>

        @GET("lookup.php")
        fun getRecipeDetails(@Query("i") recipeId: Int): Observable<RecipeListModel>
    }
}