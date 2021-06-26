package com.example.wisata.features.kuliner

import android.util.Log
import com.example.wisata.repositories.KulinerRepositoryImp
import com.example.wisata.responses.KulinerResponse
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*


class MainKulinerPresenter(
    val mView: MainKulinerContract.View,
    private val kulinerRepositoryImp: KulinerRepositoryImp,
    private val schedule: SchedulerProvider
) : MainKulinerContract.Presenter {
    private val compositeDisposable = CompositeDisposable()
    override fun getKulinerData() {
        mView.showLoading()
        compositeDisposable.add(kulinerRepositoryImp.getKuliner()
            .observeOn(schedule.ui())
            .subscribeOn(schedule.io())
            .subscribeWith(object : ResourceSubscriber<KulinerResponse>(){
                override fun onComplete() {
                    mView.hideLoading()
                }

                override fun onNext(t: KulinerResponse) {
                    mView.displayKuliner(t.kuliner)
                }

                override fun onError(e: Throwable) {
                    mView.hideLoading()
                    Log.d("ayam ", "${e.printStackTrace()}")
                    mView.displayKuliner(Collections.emptyList())
                }
            })
        )
    }

    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }
}