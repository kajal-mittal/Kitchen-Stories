package com.kmdev.bakingapp.retrofit

import com.kmdev.bakingapp.ui.models.RecipeDetailsModel
import com.kmdev.bakingapp.ui.models.RecipesModel
import com.kmdev.bakingapp.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Kajal_Mittal on 02/07/17.
 */
interface Rest {
    @GET("search")
    fun recipes(@Query("key") apiKey: String): Call<RecipesModel>

    @GET("get")
    fun recipeDetail(@Query("key") key: String,
                     @Query("rId") recipeId: String): Call<RecipeDetailsModel>


}
