package com.kairischarm.mealdb.recipe.ingredients

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup

import com.kairischarm.mealdb.R
import com.kairischarm.mealdb.baseclasses.RecyclerViewHolder
import com.kairischarm.mealdb.databinding.IngredientRecyclerViewHolderBinding

class IngredientRecyclerViewHolder(binding: IngredientRecyclerViewHolderBinding): RecyclerViewHolder<Ingredient, IngredientRecyclerViewHolderBinding>(binding) {
    companion object {
        /**
         * Create and inflate [IngredientRecyclerViewHolder]
         *
         * @param parent Parent [ViewGroup] to the ViewHolder
         * @return
         */
        fun newInstance(parent: ViewGroup): IngredientRecyclerViewHolder {
            return IngredientRecyclerViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.ingredient_recycler_view_holder, parent, false))
        }
    }

    /**
     * Populate ViewHolder with data from [Ingredient]
     *
     * @param data [Ingredient] data to populate ViewHolder
     */
    override fun setData(data: Ingredient?) {
        val binding = getBinding()

        binding?.ingredient = data
        data?.getImage()?.into(binding?.ingredientThumbnail)
    }
}