package com.kairischarm.mealdb.recipe.categories

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup

import com.kairischarm.mealdb.R
import com.kairischarm.mealdb.baseclasses.RecyclerViewHolder
import com.kairischarm.mealdb.databinding.CategoryRecyclerViewHolderBinding

class CategoryRecyclerViewHolder private constructor(binding: CategoryRecyclerViewHolderBinding, private val categorySelectedListener: CategorySelectedListener): RecyclerViewHolder<Category, CategoryRecyclerViewHolderBinding>(binding) {
    companion object {
        /**
         * Create and inflate [CategoryRecyclerViewHolder]
         *
         * @param parent Parent [ViewGroup] to the ViewHolder
         * @param categorySelectedListener [CategorySelectedListener] to be notified on click event
         * @return
         */
        fun newInstance(parent: ViewGroup, categorySelectedListener: CategorySelectedListener): CategoryRecyclerViewHolder {
            return CategoryRecyclerViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.category_recycler_view_holder, parent, false), categorySelectedListener)
        }
    }

    /**
     * Populate ViewHolder with data from [Category]
     *
     * @param data [Category] data to populate ViewHolder
     */
    override fun setData(data: Category?) {
        val binding = getBinding()

        binding?.category = data

        data?.getThumbnail()?.into(binding?.categoryThumbnail)

        binding?.categoryLayout?.setOnClickListener {
            val category = binding.category

            if(category != null)
                categorySelectedListener.categorySelected(category)
        }
    }
}