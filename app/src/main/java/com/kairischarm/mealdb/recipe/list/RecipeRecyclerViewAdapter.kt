package com.kairischarm.mealdb.recipe.list

import android.view.ViewGroup

import com.kairischarm.mealdb.baseclasses.RecyclerViewAdapter
import com.kairischarm.mealdb.recipe.RecipeMetadata
import com.kairischarm.mealdb.recipe.RecipeSelectedListener

class RecipeRecyclerViewAdapter(private var recipeSelectedListener: RecipeSelectedListener): RecyclerViewAdapter<RecipeMetadata, RecipeRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecipeRecyclerViewHolder {
        return RecipeRecyclerViewHolder.newInstance(parent, recipeSelectedListener)
    }
}