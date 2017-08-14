package com.kmdev.bakingapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmdev.bakingapp.R
import com.kmdev.bakingapp.restclient.ApiHitListener
import com.kmdev.bakingapp.restclient.ApiIds
import com.kmdev.bakingapp.restclient.ConnectionDetector
import com.kmdev.bakingapp.restclient.RestClient
import com.kmdev.bakingapp.ui.adapters.RecipesAdapter
import com.kmdev.bakingapp.ui.models.RecipesModel
import com.kmdev.bakingapp.utils.Utils
import android.widget.Toast
import com.google.gson.Gson
import com.kmdev.bakingapp.ui.activities.RecipeDetailActivity
import com.kmdev.bakingapp.ui.models.RecipeDetailsModel
import com.kmdev.bakingapp.utils.Constants
import com.kmdev.bakingapp.utils.ItemOffsetDecoration
import com.kmdev.bakingapp.utils.RecyclerItemClickListener


/**
 * Created by Kajal_Mittal on 04/07/17.
 */
public class RecipesFragment : Fragment(), ApiHitListener, SwipeRefreshLayout.OnRefreshListener {

    private var mRecyclerRecipes: RecyclerView? = null
    private var mRecipeAdapter: RecipesAdapter? = null
    private var mRecipeList = ArrayList<RecipesModel.RecipesBean>()
    private var mRestClient: RestClient? = null
    private var mSwipeRefreshLayout: SwipeRefreshLayout? = null;

    companion object {
        fun newInstance(): RecipesFragment {
            val args = Bundle()
            val fragment = RecipesFragment()
            fragment.setArguments(args)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_recipes, container, false)
        init(view)
        return view
    }


    private fun init(view: View?) {
        mRestClient = RestClient()
        mRecyclerRecipes = view?.findViewById(R.id.recycler_recepies) as RecyclerView
        mSwipeRefreshLayout = view?.findViewById(R.id.swipe_refresh_layout) as SwipeRefreshLayout
        val mStaggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        mRecyclerRecipes?.setLayoutManager(mStaggeredGridLayoutManager)
        mRecipeAdapter = RecipesAdapter(mRecipeList!!)
        mRecyclerRecipes?.setAdapter(mRecipeAdapter)
        val itemDecoration = ItemOffsetDecoration(activity, R.dimen.spacing)
        mRecyclerRecipes?.addItemDecoration(itemDecoration)

        if (ConnectionDetector.isNetworkAvailable(activity)) {
            callToGetRecipes()
        } else {
            Utils.displayDialog(activity, "", getString(R.string.internet_connection_not_available), false)
        }
        mRecyclerRecipes?.addOnItemTouchListener(
                RecyclerItemClickListener(context, object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        val recipeId = mRecipeList.get(position).recipe_id as String
                        callToGetRecipeDetails(recipeId)


                    }
                })
        )
        mSwipeRefreshLayout?.setColorSchemeColors(R.color.colorPrimary,
                R.color.colorAccent,
                R.color.colorPrimaryDark,
                R.color.black)
        mSwipeRefreshLayout?.setOnRefreshListener(this);
    }

    private fun callToGetRecipes() {
        Utils.displayLoadingDialog(activity, false)
        mRestClient!!.callback(this)
                .getRecipes(1)

    }

    private fun callToGetRecipeDetails(recipeId: String) {
        if (ConnectionDetector.isNetworkAvailable(activity)) {
            Utils.displayLoadingDialog(activity, false)
            mRestClient?.callback(this)
                    ?.getRecipeDetails(recipeId)
        } else {

        }
    }

    override fun onRefresh() {
        if (ConnectionDetector.isNetworkAvailable(activity)) {
            callToGetRecipes()
        } else {
            mSwipeRefreshLayout?.isRefreshing = false
            Utils.displayDialog(activity, "", getString(R.string.internet_connection_not_available), false)
        }

    }


    override fun onSuccessResponse(apiId: Int, response: Any) {
        Utils.dismissLoadingDialog()
        mSwipeRefreshLayout?.isRefreshing = false
        if (apiId == ApiIds.ID_RECIPES) {
            val recipeResponse = response as RecipesModel
            if (recipeResponse != null) {
                val recipeList = recipeResponse.recipes as ArrayList<RecipesModel.RecipesBean>
                if (recipeList.size > 0) {
                    mRecipeList.clear()
                    mRecipeList.addAll(recipeList)
                    if (mRecipeAdapter != null) {
                        mRecipeAdapter?.notifyDataSetChanged()
                    }
                }

            }
        } else if (apiId == ApiIds.ID_RECIPES_DETAILS) {
            val recipeResponseDetails = response as RecipeDetailsModel
            val res = Gson().toJson(recipeResponseDetails)

            if (recipeResponseDetails != null) {
                Toast.makeText(context, R.string.app_name, Toast.LENGTH_SHORT).show()
                val recipeDetailIntent = Intent(activity, RecipeDetailActivity::class.java)
                recipeDetailIntent.putExtra(Constants.ARG_RECIPE_INFO, res)
                startActivity(recipeDetailIntent)
            }

        }

    }

    override fun onFailResponse(apiId: Int, error: String) {
        mSwipeRefreshLayout?.isRefreshing = false
        Utils.dismissLoadingDialog()
        Utils.displayDialog(context, "", error, false)

    }


}

