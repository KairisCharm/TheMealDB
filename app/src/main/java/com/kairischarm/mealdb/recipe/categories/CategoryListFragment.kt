package com.kairischarm.mealdb.recipe.categories

import android.os.Bundle
import android.view.View

import com.kairischarm.mealdb.recipe.list.ListFragment

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

import javax.inject.Inject

class CategoryListFragment: ListFragment() {
    @Inject
    lateinit var categorySelectedListener: CategorySelectedListener

    private var categoriesDisposable: Disposable? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recyclerView?.setAdapter(CategoryRecyclerViewAdapter(categorySelectedListener))
    }


    override fun onResume() {
        super.onResume()

        dataProvider.getCategories().observeOn(AndroidSchedulers.mainThread()).subscribe(object: Observer<List<Category>> {
            override fun onComplete() {}

            override fun onSubscribe(disposable: Disposable) {
                categoriesDisposable?.dispose()
                categoriesDisposable = disposable
            }

            override fun onNext(categoryList: List<Category>) {
                binding?.progressBar?.visibility = View.GONE
                binding?.recyclerView?.setItems(categoryList)
            }

            override fun onError(exception: Throwable) {
                exception.printStackTrace()
            }
        })
    }

    override fun onPause() {
        categoriesDisposable?.dispose()

        super.onPause()
    }
}