package com.kairischarm.mealdb

import com.kairischarm.mealdb.robots.onCategoryListScreen

import org.junit.Test

class CategoryListFragmentTest: BaseTest() {
    @Test
    fun testCategoryFragment() {
        onCategoryListScreen {
            assertCategoryIsVisible("Dessert")
            assertDescriptionIsVisible("Delicious desserts straight from Nana's kitchen!")
            assertListHasItemCount(1)
        }
    }
}