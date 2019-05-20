package com.kairischarm.mealdb.baseclasses

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

import java.util.ArrayList

/**
 * Base class for RecyclerView adapters, both to set up standard RecyclerView behavior, and to make for easy use of
 * ViewDataBinding
 *
 * @param TData Type of data that will be accepted
 * @param TRecyclerViewHolder Type of ViewHolder that will be generated
 */
abstract class RecyclerViewAdapter<TData, TRecyclerViewHolder : RecyclerViewHolder<TData, ViewDataBinding?>> : RecyclerView.Adapter<TRecyclerViewHolder>() {
    private var dataItems: MutableList<TData>? = ArrayList()

    init {
        setUp()
    }

    /**
     * Prepare RecyclerViewAdapter with standard settings
     *
     */
    private fun setUp() {
        setHasStableIds(true)
    }

    override fun getItemCount(): Int {
        return dataItems?.size ?: 0
    }

    override fun onBindViewHolder(inHolder: TRecyclerViewHolder, inPosition: Int) {
        if (inPosition < dataItems?.size ?: 0) {
            inHolder.setData(dataItems?.get(inPosition))
        }
    }

    override fun getItemId(inPostition: Int): Long {
        return inPostition.toLong()
    }

    /**
     * Set dataSet for adapter
     *
     * @param dataItems New dataSet
     */
    internal fun setItems(dataItems: MutableList<TData>?) {
        this.dataItems = dataItems
        notifyDataSetChanged()
    }
}