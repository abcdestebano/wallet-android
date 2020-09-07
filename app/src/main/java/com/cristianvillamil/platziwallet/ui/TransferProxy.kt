package com.cristianvillamil.platziwallet.ui

class TransferProxy {
    val MAX_TRANSFER_AMOUT = 1000000
    var MIN_TRANSFER_AMOUT = 100

    fun checkTransfer(amount: Double) {
        when {
            amount > MAX_TRANSFER_AMOUT -> "La transacción excede el monto"
            amount < MIN_TRANSFER_AMOUT -> "La transacción debe ser mayor a $MIN_TRANSFER_AMOUT"
            else -> {
                doTransfer(amount)
            }
        }
    }

    private fun doTransfer(amount: Double) {

    }


}