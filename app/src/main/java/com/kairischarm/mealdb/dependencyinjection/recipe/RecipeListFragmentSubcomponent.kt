package com.kairischarm.mealdb.dependencyinjection.recipe

import com.kairischarm.mealdb.dependencyinjection.PerFragment
import com.kairischarm.mealdb.recipe.list.RecipeListFragment

import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerFragment
@Subcomponent
interface RecipeListFragmentSubcomponent : AndroidInjector<RecipeListFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<RecipeListFragment>
}