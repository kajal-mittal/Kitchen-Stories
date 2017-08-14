package com.kmdev.bakingapp.restclient

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object ConnectionDetector {


    fun isNetworkAvailable(_context: Context): Boolean {
        val connectivityManager = _context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
