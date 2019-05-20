package com.kairischarm.mealdb.baseclasses

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Base class for RecyclerView view holders to easily make use of ViewDataBinding
 *
 * @param TData Type of data needed to populate ViewHolder
 * @param TViewDataBinding Type of ViewDataBinding to be used to control the ViewHolder
 * @property binding The TViewDataBinding tobe used to control the ViewHolder
 */
abstract class RecyclerViewHolder<in TData, out TViewDataBinding : ViewDataBinding?>(private var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    /**
     * Provide the data the ViewHolder needs to populate its views
     *
     * @param data Data the ViewHolder needs to populate its views
     */
    abstract fun setData(data: TData?)

    /**
     * Get view holder's binding in its appropriate type
     *
     * @return TViewDataBinding used to populate the ViewHolder's views
     */
    protected fun getBinding(): TViewDataBinding? {
        try {
            @Suppress("UNCHECKED_CAST")
            return binding as? TViewDataBinding
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }

        return null
    }
}
