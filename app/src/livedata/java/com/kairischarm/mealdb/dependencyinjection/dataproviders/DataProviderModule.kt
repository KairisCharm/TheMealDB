package com.kairischarm.mealdb.dependencyinjection.dataproviders

import com.kairischarm.mealdb.dataproviders.DataProvider
import com.kairischarm.mealdb.network.Api

import dagger.Module
import dagger.Provides

@Module
class DataProviderModule {
    @Provides
    fun dataProvider() : DataProvider {
        return Api()
    }
}