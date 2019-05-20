package com.kairischarm.mealdb

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet

import com.kairischarm.mealdb.baseclasses.RecyclerViewAdapter
import com.kairischarm.mealdb.baseclasses.RecyclerViewHolder

class RecyclerView<TRecyclerViewAdapter : RecyclerViewAdapter<Any, RecyclerViewHolder<Any, ViewDataBinding>>> @JvmOverloads constructor(inContext: Context, inAttrs: AttributeSet? = null, inDefStyle: Int = 0) : android.support.v7.widget.RecyclerView(inContext, inAttrs, inDefStyle) {
    init {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(inContext, VERTICAL, false)
    }

    /**
     * Populate [RecyclerViewAdapter] for this [RecyclerView] with data
     *
     * @param data Data to provide to [RecyclerViewAdapter]
     */
    @Synchronized
    fun setItems(data: List<Any>) {
        recycledViewPool.clear()

        val list = mutableListOf<Any>()
        list.addAll(data)

        try {
            @Suppress("UNCHECKED_CAST")
            (adapter as? TRecyclerViewAdapter)?.setItems(list)
        } catch (exception: ClassCastException) {
            exception.printStackTrace()
        }
    }

    fun finalize() {
        adapter = null
    }
}