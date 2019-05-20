package com.kairischarm.mealdb.recipe.list

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup

import com.kairischarm.mealdb.R
import com.kairischarm.mealdb.baseclasses.RecyclerViewHolder
import com.kairischarm.mealdb.databinding.RecipeRecyclerViewHolderBinding
import com.kairischarm.mealdb.recipe.RecipeMetadata
import com.kairischarm.mealdb.recipe.RecipeSelectedListener

class RecipeRecyclerViewHolder private constructor(binding: RecipeRecyclerViewHolderBinding, private val recipeSelectedListener: RecipeSelectedListener): RecyclerViewHolder<RecipeMetadata, RecipeRecyclerViewHolderBinding>(binding) {
    companion object {
        /**
         * Create and inflate [RecipeRecyclerViewHolder]
         *
         * @param parent Parent [ViewGroup] to the ViewHolder
         * @param recipeSelectedListener [RecipeRecyclerViewHolder] to be notified on click event
         * @return
         */
        fun newInstance(parent: ViewGroup, recipeSelectedListener: RecipeSelectedListener): RecipeRecyclerViewHolder {
            return RecipeRecyclerViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recipe_recycler_view_holder, parent, false), recipeSelectedListener)
        }
    }

    /**
     * Populate ViewHolder with data from [RecipeMetadata]
     *
     * @param data [RecipeMetadata] to populate ViewHolder
     */
    override fun setData(data: RecipeMetadata?) {
        val binding = getBinding()

        binding?.recipeMetadata = data

        data?.getThumbnail()?.into(binding?.recipeThumbnail)

        binding?.recipeLayout?.setOnClickListener {
            val recipeMetadata = binding.recipeMetadata

            if(recipeMetadata != null && recipeMetadata.getName().isNotBlank())
                recipeSelectedListener.recipeSelected(recipeMetadata)
        }
    }
}