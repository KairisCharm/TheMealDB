package com.kairischarm.mealdb.recipe.ingredients

import android.view.ViewGroup

import com.kairischarm.mealdb.baseclasses.RecyclerViewAdapter

class IngredientRecyclerViewAdapter() : RecyclerViewAdapter<Ingredient, IngredientRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): IngredientRecyclerViewHolder {
        return IngredientRecyclerViewHolder.newInstance(parent)
    }
}