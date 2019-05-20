package com.kairischarm.mealdb.dependencyinjection.dataproviders

import android.app.Activity

import com.kairischarm.mealdb.dataproviders.DataProvider
import com.kairischarm.mealdb.dataproviders.test.DataProviderImpl

import dagger.Module
import dagger.Provides

@Module
class DataProviderModule {
    @Provides
    fun dataProvider(activity: Activity) : DataProvider {
        return DataProviderImpl(activity)
    }
}