package com.kmdev.bakingapp.restclient

/**
 * Created by ubuntu on 1/8/16.
 */

interface ApiHitListener {
    fun onSuccessResponse(apiId: Int, response: Any)
    fun onFailResponse(apiId: Int, error: String)

}