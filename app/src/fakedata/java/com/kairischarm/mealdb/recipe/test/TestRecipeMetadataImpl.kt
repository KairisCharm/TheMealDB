package com.kairischarm.mealdb.recipe.test

import android.app.Activity
import com.kairischarm.mealdb.R
import com.kairischarm.mealdb.recipe.RecipeMetadata

import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

open class TestRecipeMetadataImpl(private val activity: Activity) : RecipeMetadata {
    override fun getId(): Int {
        return 1
    }

    override fun getName(): String {
        return activity.resources.getString(R.string.brownies)
    }

    override fun getThumbnail(): RequestCreator {
        return Picasso.get().load(R.drawable.brownies)
    }
}