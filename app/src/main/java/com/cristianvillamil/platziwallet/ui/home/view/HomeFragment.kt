package com.cristianvillamil.platziwallet.ui.home.view

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory
import com.cristianvillamil.platziwallet.ui.home.presenter.HomePresenter
import com.cristianvillamil.platziwallet.ui.observables.AvailableBalanceObservable
import com.cristianvillamil.platziwallet.ui.observables.Observer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val favoriteTransferAdapter = FavoriteTransferAdapter()
    private var homePresenter: HomeContract.Presenter? = null
    val availableBalanceObservable = AvailableBalanceObservable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter = HomePresenter(this)
        initRecyclerView()
        homePresenter?.retrieveFavoritesTransfer()

        Picasso
            .get()
            .load("https://media.licdn.com/dms/image/C4E03AQFcCuDIJl0mKg/profile-displayphoto-shrink_200_200/0?e=1583366400&v=beta&t=ymt3xgMe5bKS-2knNDL9mQYFksP9ZHne5ugIqEyRjZs")
            .into(profilePhotoImageView)

        availableBalanceObservable.addObserver(object : Observer {
            override fun <T> notifyChange(newValue: T) {
                //amountValueTextView.text = "$ $newValue"
            }
        })

        Handler().postDelayed({
            availableBalanceObservable.changeAmount(50000.0)
        }, 5000)

        homePresenter?.getPercentageLiveData()
            ?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                //percentageText.text = it
            })
    }

    private fun initRecyclerView() {
        favoriteTransfersRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        favoriteTransfersRecyclerView.adapter = favoriteTransferAdapter
    }

    override fun toggleLoader(visibility: Int) {
        home_loader.visibility = visibility
    }

    override fun showFavoritesTransfer(favoritesTransfer: List<FavoriteTransfer>) {
        favoriteTransferAdapter.setData(favoritesTransfer)
        val dialogFactory = MessageFactory()
        val dialog = context?.let { dialogFactory.getDialog(it, MessageFactory.TYPE_SUCCESS) }
        //dialog?.show()
    }
}