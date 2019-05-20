package com.kairischarm.mealdb.recipe.ingredients

import com.squareup.picasso.RequestCreator

interface Ingredient {
    fun getDescription(): String
    fun getImage(): RequestCreator
}