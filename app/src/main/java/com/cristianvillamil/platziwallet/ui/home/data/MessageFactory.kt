package com.cristianvillamil.platziwallet.ui.home.data

import android.app.AlertDialog
import android.content.Context

class MessageFactory {

    companion object {
        const val TYPE_ERROR = "typeError"
        const val TYPE_SUCCESS = "typeSuccess"
    }

    fun getDialog(context: Context, type: String): AlertDialog.Builder {
        return when (type) {
            TYPE_ERROR -> AlertDialog.Builder(context).setMessage("Error")
            TYPE_SUCCESS -> AlertDialog.Builder(context).setMessage("Success")
            else -> AlertDialog.Builder(context).setMessage("Default")
        }
    }

}