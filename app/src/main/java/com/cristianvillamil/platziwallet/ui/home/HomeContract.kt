package com.cristianvillamil.platziwallet.ui.home

import androidx.lifecycle.LiveData

interface HomeContract {

    interface View {
        fun toggleLoader(visibility: Int)
        fun showFavoritesTransfer(favoritesTransfer: List<FavoriteTransfer>)
    }

    interface Presenter {
        fun retrieveFavoritesTransfer()
        fun getPercentageLiveData(): LiveData<String>
    }

    interface OnResponseCallback {
        fun onResponse(favoritesTransfer: List<FavoriteTransfer>)
    }

}