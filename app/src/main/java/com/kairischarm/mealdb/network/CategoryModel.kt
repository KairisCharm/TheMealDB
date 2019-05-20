package com.kairischarm.mealdb.network

import com.kairischarm.mealdb.recipe.categories.Category

import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

internal class CategoryModel: Category {
    private var idCategory: Int = 0
    private var strCategory: String = ""
    private var strCategoryThumb: String = ""
    private var strCategoryDescription: String = ""

    override fun getId(): Int {
        return idCategory
    }

    override fun getName(): String {
        return strCategory
    }

    override fun getThumbnail(): RequestCreator {
        return Picasso.get().load(strCategoryThumb)
    }

    override fun getDescription(): String {
        return strCategoryDescription
    }
}