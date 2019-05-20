package com.kairischarm.mealdb

import com.kairischarm.mealdb.dependencyinjection.DaggerApplicationComponent
import com.kairischarm.mealdb.network.RecipeModel

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

import javax.inject.Inject

class Application @Inject constructor() : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(this)
    }
}