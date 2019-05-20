package com.kairischarm.mealdb.recipe.categories

interface CategorySelectedListener {
    @Throws(IllegalAccessException::class)
    fun categorySelected(category: Category)
}