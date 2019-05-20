package com.kairischarm.mealdb.dependencyinjection.recipe.categories

import com.kairischarm.mealdb.dependencyinjection.PerFragment
import com.kairischarm.mealdb.recipe.categories.CategoryListFragment

import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerFragment
@Subcomponent
interface CategoryListFragmentSubcomponent : AndroidInjector<CategoryListFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<CategoryListFragment>
}