package com.kairischarm.mealdb.recipe.list

import android.os.Bundle
import android.view.View

import com.kairischarm.mealdb.recipe.RecipeMetadata
import com.kairischarm.mealdb.recipe.RecipeSelectedListener

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

import javax.inject.Inject

class RecipeListFragment : ListFragment() {
    companion object {
        const val CATEGORY_NAME = "CATEGORY_NAME"
    }

    @Inject
    lateinit var recipeSelectedListener: RecipeSelectedListener

    private var recipesDisposable: Disposable? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recyclerView?.setAdapter(RecipeRecyclerViewAdapter(recipeSelectedListener))
    }

    override fun onResume() {
        super.onResume()

        val categoryName = arguments?.getString(CATEGORY_NAME)
        binding?.listTitle?.text = categoryName
        binding?.listTitle?.visibility = View.VISIBLE

        dataProvider.getRecipesMetadata(categoryName?: "").observeOn(AndroidSchedulers.mainThread()).subscribe(object: Observer<List<RecipeMetadata>> {
            override fun onComplete() {}

            override fun onSubscribe(disposable: Disposable) {
                recipesDisposable?.dispose()
                recipesDisposable = disposable
            }

            override fun onNext(recipeList: List<RecipeMetadata>) {
                binding?.progressBar?.visibility = View.GONE
                binding?.recyclerView?.setItems(recipeList)
                binding?.listTitleDivider?.visibility = View.VISIBLE
            }

            override fun onError(exception: Throwable) {
                exception.printStackTrace()
            }
        })
    }

    override fun onPause() {
        recipesDisposable?.dispose()

        super.onPause()
    }
}