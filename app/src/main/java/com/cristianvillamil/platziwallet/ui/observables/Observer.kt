package com.cristianvillamil.platziwallet.ui.observables

interface Observer {

    fun <T> notifyChange(newValue: T)

}