package com.kmdev.bakingapp.restclient;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;
/**
 * Created by ububtu on 13/7/16.
 */
public class BaseRestClient {
    public final Context _context;
    protected BaseRestClient(Context _context) {
        this._context = _context;
    }

}
