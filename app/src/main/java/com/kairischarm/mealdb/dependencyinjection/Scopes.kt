package com.kairischarm.mealdb.dependencyinjection

import javax.inject.Scope

import kotlin.annotation.Retention

@Scope
@Retention
annotation class PerContext

@Scope
@Retention
annotation class PerFragment