package com.kairischarm.mealdb.recipe.categories.test

import android.app.Activity

import com.kairischarm.mealdb.R
import com.kairischarm.mealdb.recipe.categories.Category

import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

import javax.inject.Inject

class TestCategoryImpl @Inject constructor(private val activity: Activity): Category {
    override fun getId(): Int {
        return 1
    }

    override fun getName(): String {
        return activity.resources.getString(R.string.dessert)
    }

    override fun getThumbnail(): RequestCreator {
        return Picasso.get().load(R.drawable.chocolate_small)
    }

    override fun getDescription(): String {
        return activity.resources.getString(R.string.delicious_sweets_straight_from_nanas_house)
    }
}