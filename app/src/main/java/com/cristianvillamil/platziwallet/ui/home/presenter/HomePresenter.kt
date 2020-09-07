package com.cristianvillamil.platziwallet.ui.home.presenter

import android.os.Handler
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cristianvillamil.platziwallet.UserSingleton
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeInteractor
import com.cristianvillamil.platziwallet.ui.home.data.User

class HomePresenter(val view: HomeContract.View) : HomeContract.Presenter {

    val homeInteractor = HomeInteractor()
    private val percentageLiveData: MutableLiveData<String> = MutableLiveData()

    override fun retrieveFavoritesTransfer() {
        view.toggleLoader(View.VISIBLE)

        homeInteractor.retrieveFavoriteTransferFromCache(object : HomeContract.OnResponseCallback {
            override fun onResponse(favoritesTransfer: List<FavoriteTransfer>) {
                view.toggleLoader(View.GONE)

                UserSingleton.getInstance().name

                val user = User.Builder()
                    .setUsername("abcdesteban")
                    .setPassword("123456")

                user.build()

                Handler().postDelayed({
                    view.showFavoritesTransfer(favoritesTransfer)
                    percentageLiveData.value = "40%"
                }, 5000)
            }
        })
    }

    override fun getPercentageLiveData(): LiveData<String> {
        return percentageLiveData
    }

}