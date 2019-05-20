package com.kairischarm.mealdb.dependencyinjection

import com.kairischarm.mealdb.MainActivity

import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerContext
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivitySubcomponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}