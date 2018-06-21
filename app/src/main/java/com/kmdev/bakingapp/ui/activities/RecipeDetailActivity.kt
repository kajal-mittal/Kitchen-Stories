package com.kmdev.bakingapp.ui.activities

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson

import com.kmdev.bakingapp.R
import com.kmdev.bakingapp.ui.models.RecipeDetailsModel
import com.kmdev.bakingapp.utils.Constants
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
import android.app.Activity
import android.support.v7.widget.RecyclerView


class RecipeDetailActivity : AppCompatActivity(),View.OnClickListener {

    var mRecipeString: String? = null
    private var mRecipeDetails: RecipeDetailsModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        val publisherUrl = findViewById(R.id.tv_publisher_url) as TextView
        setSupportActionBar(toolbar)
        val fab = findViewById(R.id.fab) as FloatingActionButton
        val webview = findViewById(R.id.webview) as WebView
        val recyclerIngredients = findViewById(R.id.recycler_ingredients) as RecyclerView
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        mRecipeString = intent.getStringExtra(Constants.ARG_RECIPE_INFO)
        mRecipeDetails = Gson().fromJson<RecipeDetailsModel>(mRecipeString, RecipeDetailsModel::class.java!!)
        Toast.makeText(applicationContext, (mRecipeDetails as RecipeDetailsModel?)?.recipe?.title, Toast.LENGTH_SHORT).show()
        publisherUrl?.setText((mRecipeDetails as RecipeDetailsModel?)?.recipe?.publisher)


        webview.getSettings().setJavaScriptEnabled(true)

        val activity = this
        webview.setWebChromeClient(object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {
                // Activities and WebViews measure progress with different scales.
                // The progress meter will automatically disappear when we reach 100%
                activity.setProgress(progress * 1000)
            }
        })
        webview.setWebViewClient(object : WebViewClient() {
            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show()
            }
        })

        webview.loadUrl((mRecipeDetails as RecipeDetailsModel)?.recipe?.source_url)


    }
    override fun onClick(v: View?) {

    }

}
