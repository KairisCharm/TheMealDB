package com.kairischarm.mealdb.dependencyinjection.recipe

import com.kairischarm.mealdb.dependencyinjection.PerFragment
import com.kairischarm.mealdb.recipe.RecipeFragment

import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerFragment
@Subcomponent
interface RecipeFragmentSubcomponent : AndroidInjector<RecipeFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<RecipeFragment>
}