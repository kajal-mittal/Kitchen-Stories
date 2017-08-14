package com.kmdev.bakingapp.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kmdev.bakingapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val thread = Thread(Runnable {
            try {
                Thread.sleep((3 * 1000).toLong())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            val splashIntent = Intent(baseContext, HomeActivity::class.java)
            startActivity(splashIntent)
            finish()
        })
        thread.start()

    }
}
