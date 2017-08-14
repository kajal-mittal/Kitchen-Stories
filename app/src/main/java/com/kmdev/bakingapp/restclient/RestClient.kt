package com.kmdev.bakingapp.restclient

import android.content.Context
import com.kmdev.bakingapp.retrofit.Rest
import com.kmdev.bakingapp.retrofit.RestService
import com.kmdev.bakingapp.ui.models.RecipeDetailsModel
import com.kmdev.bakingapp.ui.models.RecipesModel
import com.kmdev.bakingapp.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by ububtu on 13/7/16.
 */
class RestClient {
    internal var apiHitListener: ApiHitListener? = null
    private var api: Rest? = null
    private val `object`: Any? = null

    fun callback(apiHitListener: ApiHitListener): RestClient {
        this.apiHitListener = apiHitListener
        return this
    }

    private fun getApi(): Rest {
        if (api == null) {
            api = RestService.getService()
        }

        return api as Rest
    }

    fun getRecipes(current_page: Int) {
        val call = getApi().recipes(Constants.API_KEY)
        call.enqueue(object : Callback<RecipesModel> {
            override fun onResponse(call: Call<RecipesModel>, response: Response<RecipesModel>) {
                apiHitListener?.onSuccessResponse(ApiIds.ID_RECIPES, response!!.body())
            }

            override fun onFailure(call: Call<RecipesModel>, t: Throwable) {
                apiHitListener?.onFailResponse(ApiIds.ID_RECIPES, t.message!!)
            }
        })
    }

    fun getRecipeDetails(recipeId: String) {
        val call = getApi().recipeDetail(Constants.API_KEY, recipeId)
        call.enqueue(object : Callback<RecipeDetailsModel> {
            override fun onResponse(call: Call<RecipeDetailsModel>?, response: Response<RecipeDetailsModel>?) {
                apiHitListener?.onSuccessResponse(ApiIds.ID_RECIPES_DETAILS, response!!.body())

            }


            override fun onFailure(call: Call<RecipeDetailsModel>, t: Throwable) {
                apiHitListener?.onFailResponse(ApiIds.ID_RECIPES_DETAILS, t.message!!)
            }
        })
    }


}