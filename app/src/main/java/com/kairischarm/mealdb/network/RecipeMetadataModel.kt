package com.kairischarm.mealdb.network

import com.kairischarm.mealdb.recipe.RecipeMetadata

import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

internal open class RecipeMetadataModel: RecipeMetadata {
    private val strMeal: String = ""
    private val strMealThumb: String = ""
    private val idMeal: Int = 0

    override fun getId(): Int {
        return idMeal
    }

    override fun getName(): String {
        return strMeal
    }

    override fun getThumbnail(): RequestCreator {
        return Picasso.get().load(strMealThumb)
    }
}