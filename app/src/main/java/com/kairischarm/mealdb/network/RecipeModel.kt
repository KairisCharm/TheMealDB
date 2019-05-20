package com.kairischarm.mealdb.network

import android.support.annotation.VisibleForTesting

import com.kairischarm.mealdb.recipe.Recipe
import com.kairischarm.mealdb.recipe.ingredients.Ingredient

import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

internal class RecipeModel: RecipeMetadataModel(), Recipe {
    override fun getInstructions(): String {
        return strInstructions
    }

    override fun getIngredients(): List<Ingredient> {
        val result: ArrayList<RecipeModelIngredient> = arrayListOf()
        addIngredient(result, strMeasure1, strIngredient1)
        addIngredient(result, strMeasure2, strIngredient2)
        addIngredient(result, strMeasure3, strIngredient3)
        addIngredient(result, strMeasure4, strIngredient4)
        addIngredient(result, strMeasure5, strIngredient5)
        addIngredient(result, strMeasure6, strIngredient6)
        addIngredient(result, strMeasure7, strIngredient7)
        addIngredient(result, strMeasure8, strIngredient8)
        addIngredient(result, strMeasure9, strIngredient9)
        addIngredient(result, strMeasure10, strIngredient10)
        addIngredient(result, strMeasure11, strIngredient11)
        addIngredient(result, strMeasure12, strIngredient12)
        addIngredient(result, strMeasure13, strIngredient13)
        addIngredient(result, strMeasure14, strIngredient14)
        addIngredient(result, strMeasure15, strIngredient15)
        addIngredient(result, strMeasure16, strIngredient16)
        addIngredient(result, strMeasure17, strIngredient17)
        addIngredient(result, strMeasure18, strIngredient18)
        addIngredient(result, strMeasure19, strIngredient19)
        addIngredient(result, strMeasure20, strIngredient20)

        return result
    }

    private val strInstructions: String = ""
    private val strIngredient1: String = ""
    private val strIngredient2: String = ""
    private val strIngredient3: String = ""
    private val strIngredient4: String = ""
    private val strIngredient5: String = ""
    private val strIngredient6: String = ""
    private val strIngredient7: String = ""
    private val strIngredient8: String = ""
    private val strIngredient9: String = ""
    private val strIngredient10: String = ""
    private val strIngredient11: String = ""
    private val strIngredient12: String = ""
    private val strIngredient13: String = ""
    private val strIngredient14: String = ""
    private val strIngredient15: String = ""
    private val strIngredient16: String = ""
    private val strIngredient17: String = ""
    private val strIngredient18: String = ""
    private val strIngredient19: String = ""
    private val strIngredient20: String = ""
    private val strMeasure1: String = ""
    private val strMeasure2: String = ""
    private val strMeasure3: String = ""
    private val strMeasure4: String = ""
    private val strMeasure5: String = ""
    private val strMeasure6: String = ""
    private val strMeasure7: String = ""
    private val strMeasure8: String = ""
    private val strMeasure9: String = ""
    private val strMeasure10: String = ""
    private val strMeasure11: String = ""
    private val strMeasure12: String = ""
    private val strMeasure13: String = ""
    private val strMeasure14: String = ""
    private val strMeasure15: String = ""
    private val strMeasure16: String = ""
    private val strMeasure17: String = ""
    private val strMeasure18: String = ""
    private val strMeasure19: String = ""
    private val strMeasure20: String = ""

    companion object {
        @VisibleForTesting
        internal fun addIngredient(list: ArrayList<RecipeModelIngredient>, measure: String?, ingredient: String?) {
            if (ingredient?.isBlank() == false) {
                list.add(object : RecipeModelIngredient {
                    override fun getDescription(): String {
                        if (measure?.isBlank() != false)
                            return "$ingredient"

                        return "$measure $ingredient"
                    }

                    override fun getImage(): RequestCreator {
                        return Picasso.get().load(getImageUrl())
                    }

                    override fun getImageUrl(): String {
                        return "https://www.themealdb.com/images/ingredients/$ingredient-Small.png"
                    }
                })
            }
        }
    }

    interface RecipeModelIngredient: Ingredient {
        fun getImageUrl(): String
    }
}