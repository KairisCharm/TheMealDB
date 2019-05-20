package com.kairischarm.mealdb.recipe.categories

import com.squareup.picasso.RequestCreator

interface Category {
    fun getId(): Int
    fun getName(): String
    fun getThumbnail(): RequestCreator
    fun getDescription(): String
}