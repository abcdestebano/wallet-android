package com.cristianvillamil.platziwallet.ui.observables

interface Observable {

    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun <T> notifyObservers(newValue: T)

}