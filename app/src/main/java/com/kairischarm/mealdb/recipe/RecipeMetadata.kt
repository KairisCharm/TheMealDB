package com.kairischarm.mealdb.recipe

import com.squareup.picasso.RequestCreator

interface RecipeMetadata {
    fun getId(): Int
    fun getName(): String
    fun getThumbnail(): RequestCreator
}