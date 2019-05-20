package com.kairischarm.mealdb.recipe.categories

import android.view.ViewGroup

import com.kairischarm.mealdb.baseclasses.RecyclerViewAdapter

class CategoryRecyclerViewAdapter(private val categorySelectedListener: CategorySelectedListener) : RecyclerViewAdapter<Category, CategoryRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): CategoryRecyclerViewHolder {
        return CategoryRecyclerViewHolder.newInstance(parent, categorySelectedListener)
    }
}