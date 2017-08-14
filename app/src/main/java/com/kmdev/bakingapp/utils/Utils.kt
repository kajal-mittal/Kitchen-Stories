package com.kmdev.bakingapp.utils

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.preference.PreferenceManager
import android.support.v7.app.AlertDialog
import com.kmdev.bakingapp.R



/**
 * Created by Kajal_Mittal on 05/07/17.
 */
object Utils {
    var mAlertDialog: AlertDialog? = null
    var mLoadingDialog: ProgressDialog? = null

    fun displayDialog(context: Context, title: String, content: String, cancelable: Boolean) {
        mAlertDialog = AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(content)
                .setCancelable(cancelable)
                .setNegativeButton(R.string.dismiss, DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                }).create()
        mAlertDialog!!.show()
    }


    fun displayLoadingDialog(context: Context?, isCancellable: Boolean) {
        mLoadingDialog = ProgressDialog(context)
        mLoadingDialog?.setTitle(R.string.loading)
        mLoadingDialog!!.setMessage(context!!.getString(R.string.please_wait))
        mLoadingDialog!!.isIndeterminate = true
        mLoadingDialog!!.setCancelable(isCancellable)
        mLoadingDialog!!.show()

    }


    fun dismissLoadingDialog() {
        mLoadingDialog!!.dismiss()
        mLoadingDialog = null

    }
}