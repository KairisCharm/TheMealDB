package com.kairischarm.mealdb.robots

import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers

import com.kairischarm.mealdb.R

fun onCategoryListScreen(func: CategoryListRobot.() -> Unit) = CategoryListRobot().apply(func)

class CategoryListRobot: BaseRobot() {
    fun assertCategoryIsVisible(categoryName: String) {
        findCategoryWithName(categoryName).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun assertDescriptionIsVisible(description: String) {
        findViewWithIdAndText(R.id.categoryDescription, description)
    }

    fun assertListHasItemCount(count: Int) {
        listHasItemCount(count, R.id.recyclerView)
    }

    fun selectCategory(categoryName: String) {
        click(findCategoryWithName(categoryName))
    }

    private fun findCategoryWithName(categoryName: String): ViewInteraction {
        return findViewWithIdAndText(R.id.categoryName, categoryName)
    }
}