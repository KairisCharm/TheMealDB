package com.kairischarm.mealdb.dependencyinjection

import android.app.Activity

import dagger.Binds
import dagger.Module

import com.kairischarm.mealdb.MainActivity
import com.kairischarm.mealdb.dependencyinjection.dataproviders.DataProviderModule
import com.kairischarm.mealdb.dependencyinjection.recipe.RecipeFragmentSubcomponent
import com.kairischarm.mealdb.dependencyinjection.recipe.RecipeListFragmentSubcomponent
import com.kairischarm.mealdb.dependencyinjection.recipe.categories.CategoryListFragmentSubcomponent
import com.kairischarm.mealdb.recipe.RecipeFragment
import com.kairischarm.mealdb.recipe.RecipeSelectedListener
import com.kairischarm.mealdb.recipe.categories.CategoryListFragment
import com.kairischarm.mealdb.recipe.categories.CategorySelectedListener
import com.kairischarm.mealdb.recipe.list.RecipeListFragment

import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(includes = [DataProviderModule::class],
        subcomponents = [CategoryListFragmentSubcomponent::class,
                         RecipeListFragmentSubcomponent::class,
                         RecipeFragmentSubcomponent::class])
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ClassKey(CategoryListFragment::class)
    internal abstract fun bindCategoryListFragmentInjectorFactory(factory: CategoryListFragmentSubcomponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(RecipeListFragment::class)
    internal abstract fun bindRecipeListFragmentInjectorFactory(factory: RecipeListFragmentSubcomponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(RecipeFragment::class)
    internal abstract fun bindRecipeFragmentInjectorFactory(factory: RecipeFragmentSubcomponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @PerContext
    internal abstract fun activity(mainActivity: MainActivity): Activity

    @Binds
    @PerContext
    internal abstract fun defaultCategorySelectedListener(mainActivity: MainActivity): CategorySelectedListener

    @Binds
    @PerContext
    internal abstract fun defaultRecipeSelectedListener(mainActivity: MainActivity): RecipeSelectedListener
}