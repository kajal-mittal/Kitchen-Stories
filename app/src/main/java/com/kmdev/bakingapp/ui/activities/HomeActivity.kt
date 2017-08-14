package com.kmdev.bakingapp.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import com.kmdev.bakingapp.R
import com.kmdev.bakingapp.ui.fragments.RecipesFragment


class HomeActivity : AppCompatActivity() {
    private var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        initNavigationView()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home_fragment, RecipesFragment.newInstance(),
                RecipesFragment.newInstance().javaClass.getSimpleName()).commit()
    }

    private fun initNavigationView() {
        val mNavigationView = findViewById(R.id.nav_view) as NavigationView
        mNavigationView.setNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            if (id == R.id.nav_home) {
            } else if (id == R.id.nav_favourite) {
            } else if (id == R.id.nav_settings) {

            } else if (id == R.id.nav_share) {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Take a look " + "at \"BakingApp\"\nhttps://play.google.com/store/apps/details?id=com.kajalmittal.flix")
                sendIntent.type = "text/plain"
                startActivity(sendIntent)
            } else if (id == R.id.nav_video_receipes) {

            }

            val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
            drawer.closeDrawer(GravityCompat.START)
            true


        }
    }
}
