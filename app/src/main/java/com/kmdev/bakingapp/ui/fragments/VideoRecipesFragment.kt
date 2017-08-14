package com.kmdev.bakingapp.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmdev.bakingapp.R
import com.kmdev.bakingapp.restclient.ApiHitListener

/**
 * Created by Kajal_Mittal on 14/08/17.
 */
public class VideoRecipesFragment : Fragment() {
    companion object {
        fun newInstance(): VideoRecipesFragment {
            val args = Bundle()
            val fragment = VideoRecipesFragment()
            fragment.setArguments(args)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_video_recipes, container, false)
        init(view)
        return view
    }

    private fun init(view: View?) {


    }

}