package com.kmdev.bakingapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kmdev.bakingapp.R
import com.kmdev.bakingapp.ui.models.RecipesModel
import com.squareup.picasso.Picasso

/**
 * Created by Kajal_Mittal on 04/07/17.
 */
public class RecipesAdapter(recipesList: List<RecipesModel.RecipesBean>) : RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {
    var mRecipesList: List<RecipesModel.RecipesBean>? = recipesList
    private var mViewHolder: ViewHolder? = null


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):ViewHolder{
        val inflater = LayoutInflater.from(parent!!.getContext())
        val view = inflater.inflate(R.layout.item_recipe, parent, false)
        mViewHolder = ViewHolder(view)
        return mViewHolder as ViewHolder
    }

    override fun onBindViewHolder(holder: RecipesAdapter.ViewHolder?, position: Int) {
        Picasso.with(holder?.itemView?.context)
                .load(mRecipesList?.get(position)?.image_url)
                .placeholder(R.color.photo_placeholder)   // optional
                .error(R.color.photo_placeholder)      // optional
                .into(holder?.imageRecipe)
        holder?.tvRecipeTitle?.setText(mRecipesList?.get(position)?.title)
        holder?.tvRecipeDes?.setText(mRecipesList?.get(position)?.publisher)


    }

    override fun getItemCount(): Int {
        return mRecipesList!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageRecipe: ImageView? = null
        var tvRecipeTitle: TextView? = null
        var tvRecipeDes: TextView? = null


        init {
            imageRecipe = itemView.findViewById(R.id.image_recipe) as ImageView
            tvRecipeTitle = itemView.findViewById(R.id.tv_recipe_title) as TextView
            tvRecipeDes = itemView.findViewById(R.id.tv_recipe_description) as TextView


        }
    }


}
