package com.kairischarm.mealdb.dependencyinjection

import com.kairischarm.mealdb.MainActivity

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(includes = [AndroidSupportInjectionModule::class],
        subcomponents = [MainActivitySubcomponent::class])
abstract class ApplicationModule {
    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindMainActivityInjectorFactory(factory: MainActivitySubcomponent.Factory): AndroidInjector.Factory<*>
}