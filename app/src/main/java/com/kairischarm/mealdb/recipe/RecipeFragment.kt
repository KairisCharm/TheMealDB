package com.kairischarm.mealdb.recipe

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kairischarm.mealdb.R
import com.kairischarm.mealdb.databinding.RecipeFragmentBinding
import com.kairischarm.mealdb.dataproviders.DataProvider
import com.kairischarm.mealdb.recipe.ingredients.IngredientRecyclerViewAdapter

import dagger.android.support.DaggerFragment

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

import javax.inject.Inject

class RecipeFragment: DaggerFragment() {
    companion object {
        const val RECIPE_ID = "RECIPE_ID"
    }

    @Inject
    lateinit var dataProvider: DataProvider

    var recipeDisposable: Disposable? = null
    var binding: RecipeFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.recipe_fragment, container, false)

        binding?.ingredientsList?.setAdapter(IngredientRecyclerViewAdapter())

        return binding?.root
    }


    override fun onResume() {
        super.onResume()

        dataProvider.getRecipe(arguments?.getInt(RECIPE_ID)?: 0).observeOn(AndroidSchedulers.mainThread()).subscribe(object: Observer<Recipe> {
            override fun onComplete() {}

            override fun onSubscribe(disposable: Disposable) {
                recipeDisposable?.dispose()
                recipeDisposable = disposable
            }

            override fun onNext(recipe: Recipe) {
                binding?.recipe = recipe

                recipe.getThumbnail().into(binding?.recipeImage)

                binding?.ingredientsList?.setItems(recipe.getIngredients())

                binding?.progressBar?.visibility = View.GONE
                binding?.cardView?.visibility = View.VISIBLE
            }

            override fun onError(exception: Throwable) {
                exception.printStackTrace()
            }
        })
    }

    override fun onPause() {
        recipeDisposable?.dispose()

        super.onPause()
    }
}