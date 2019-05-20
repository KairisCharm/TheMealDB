package com.kairischarm.mealdb

import android.os.Bundle
import android.support.v4.app.Fragment

import com.kairischarm.mealdb.dependencyinjection.PerContext
import com.kairischarm.mealdb.recipe.RecipeFragment
import com.kairischarm.mealdb.recipe.RecipeMetadata
import com.kairischarm.mealdb.recipe.RecipeSelectedListener
import com.kairischarm.mealdb.recipe.categories.Category
import com.kairischarm.mealdb.recipe.categories.CategoryListFragment
import com.kairischarm.mealdb.recipe.categories.CategorySelectedListener
import com.kairischarm.mealdb.recipe.list.RecipeListFragment

import dagger.android.support.DaggerAppCompatActivity

@PerContext
class MainActivity : DaggerAppCompatActivity(), CategorySelectedListener, RecipeSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        if(supportFragmentManager.fragments.isEmpty())
            navigateToPage(CategoryListFragment(), false)
    }

    /**
     * Navigate to [RecipeListFragment] for given meal category
     *
     * @param category [Category] to display
     */
    override fun categorySelected(category: Category) {
        if(category.getName().isBlank())
            throw IllegalAccessException("Category name cannot be blank")

        val fragmentArguments = Bundle()
        fragmentArguments.putString(RecipeListFragment.CATEGORY_NAME, category.getName())

        val fragment = RecipeListFragment()
        fragment.arguments = fragmentArguments

        navigateToPage(fragment, true)
    }

    /**
     * Navigate to [RecipeFragment] for given recipe
     *
     * @param recipe [RecipeMetadata] for recipe to display
     */
    override fun recipeSelected(recipe: RecipeMetadata) {
        // Normally I would throw an exception if the recipe's ID was invalid, but I don't know what the rules of a
        // valid recipeId are

        val fragmentArguments = Bundle()
        fragmentArguments.putInt(RecipeFragment.RECIPE_ID, recipe.getId())

        val fragment = RecipeFragment()
        fragment.arguments = fragmentArguments

        navigateToPage(fragment, true)
    }

    private fun navigateToPage(fragment: Fragment, pushToBackStack: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragmentLayout, fragment)

        if (pushToBackStack)
            fragmentTransaction.addToBackStack(fragment.javaClass.name)

        fragmentTransaction.commit()
    }
}