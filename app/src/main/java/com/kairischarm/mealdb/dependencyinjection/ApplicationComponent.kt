package com.kairischarm.mealdb.dependencyinjection

import com.kairischarm.mealdb.Application

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
                        ApplicationModule::class])
interface ApplicationComponent: AndroidInjector<Application> {
    @Component.Factory
    abstract class Factory: AndroidInjector.Factory<Application>
}