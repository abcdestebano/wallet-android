package com.cristianvillamil.platziwallet.ui.observables

class AvailableBalanceObservable : Observable {

    private val amountObserverList: MutableList<Observer> = mutableListOf()
    private var amount: Double = 0.0

    fun changeAmount(newValue: Double) {
        amount = newValue
        notifyObservers(amount)
    }

    override fun addObserver(observer: Observer) {
        amountObserverList.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        amountObserverList.remove(observer)
    }

    override fun <T> notifyObservers(newValue: T) {
        amountObserverList.forEach { observer ->
            observer.notifyChange(newValue)
        }
    }

}