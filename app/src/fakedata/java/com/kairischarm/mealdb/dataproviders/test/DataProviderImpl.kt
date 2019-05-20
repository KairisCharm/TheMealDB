package com.kairischarm.mealdb.dataproviders.test

import android.app.Activity

import com.kairischarm.mealdb.dataproviders.DataProvider
import com.kairischarm.mealdb.recipe.categories.Category
import com.kairischarm.mealdb.recipe.categories.test.TestCategoryImpl
import com.kairischarm.mealdb.recipe.Recipe
import com.kairischarm.mealdb.recipe.RecipeMetadata
import com.kairischarm.mealdb.recipe.test.TestRecipeImpl
import com.kairischarm.mealdb.recipe.test.TestRecipeMetadataImpl

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

import javax.inject.Inject

class DataProviderImpl @Inject constructor(activity: Activity): DataProvider {
    // Normally, I would add more test data, but in the interest of time, I'll keep it to this
    private val categoryDataSubject = BehaviorSubject.create<List<Category>>()
    private val recipeMetadataSubject = BehaviorSubject.create<List<RecipeMetadata>>()
    private val recipeSubject = BehaviorSubject.create<Recipe>()

    init {
        categoryDataSubject.onNext(arrayListOf(TestCategoryImpl(activity)))
        recipeMetadataSubject.onNext(arrayListOf(TestRecipeMetadataImpl(activity)))
        recipeSubject.onNext(TestRecipeImpl(activity))
    }

    override fun getCategories(): Observable<List<Category>> {
        return categoryDataSubject
    }

    override fun getRecipesMetadata(categoryName: String): Observable<List<RecipeMetadata>> {
        return recipeMetadataSubject
    }

    override fun getRecipe(recipeId: Int): Observable<Recipe> {
        return recipeSubject
    }
}