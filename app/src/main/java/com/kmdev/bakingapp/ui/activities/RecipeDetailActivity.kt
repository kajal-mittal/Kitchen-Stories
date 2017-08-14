package com.kmdev.bakingapp.ui.activities

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import com.google.gson.Gson

import com.kmdev.bakingapp.R
import com.kmdev.bakingapp.ui.models.RecipeDetailsModel
import com.kmdev.bakingapp.utils.Constants

class RecipeDetailActivity : AppCompatActivity() {
    var mRecipeString: String? = null
    private var mRecipeDetails: RecipeDetailsModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        mRecipeString = intent.getStringExtra(Constants.ARG_RECIPE_INFO)
        mRecipeDetails = Gson().fromJson<RecipeDetailsModel>(mRecipeString, RecipeDetailsModel::class.java!!)
        Toast.makeText(applicationContext, (mRecipeDetails as RecipeDetailsModel?)?.recipe?.title, Toast.LENGTH_SHORT).show()


    }
}
