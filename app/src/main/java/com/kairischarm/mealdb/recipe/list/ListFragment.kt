package com.kairischarm.mealdb.recipe.list

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kairischarm.mealdb.R
import com.kairischarm.mealdb.databinding.ListFragmentBinding
import com.kairischarm.mealdb.dataproviders.DataProvider

import dagger.android.support.DaggerFragment

import javax.inject.Inject

abstract class ListFragment: DaggerFragment() {
    @Inject
    lateinit var dataProvider: DataProvider

    protected var binding: ListFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false)

        return binding?.root
    }
}