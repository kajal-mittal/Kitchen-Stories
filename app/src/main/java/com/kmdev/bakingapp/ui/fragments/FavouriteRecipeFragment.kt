package com.kmdev.bakingapp.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Created by Kajal_Mittal on 14/08/17.
 */
public class FavouriteRecipeFragment : Fragment() {
    companion object {
        fun newInstance(): FavouriteRecipeFragment {
            val args = Bundle()
            val fragment = FavouriteRecipeFragment()
            fragment.setArguments(args)
            return fragment
        }
    }

}