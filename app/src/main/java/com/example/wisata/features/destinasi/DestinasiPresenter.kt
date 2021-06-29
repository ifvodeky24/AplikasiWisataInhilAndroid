package com.example.wisata.features.destinasi

import android.util.Log
import com.example.wisata.features.jenisdestinasi.JenisDestinasiContract
import com.example.wisata.repositories.DestinasiRepositoryImp
import com.example.wisata.repositories.JenisDestinasiRepositoryImp
import com.example.wisata.responses.DestinasiResponse
import com.example.wisata.responses.JenisDestinasiResponse
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*


class DestinasiPresenter(
    val mView: DestinasiContract.View,
    val destinasiRepositoryImp: DestinasiRepositoryImp,
    val schedule: SchedulerProvider
) : DestinasiContract.Presenter{
    val compositeDisposable = CompositeDisposable()
    override fun getDestinasiData(jenis: Int) {
        mView.showLoading()
        compositeDisposable.add(destinasiRepositoryImp.getDestinasi(jenis)
            .observeOn(schedule.ui())
            .subscribeOn(schedule.io())
            .subscribeWith(object : ResourceSubscriber<DestinasiResponse>(){
                override fun onComplete() {
                    mView.hideLoading()
                }

                override fun onNext(t: DestinasiResponse) {
                    mView.displayDestinasi(t.destinasi)
                    Log.d("dsdsdsdsds", "ini ${t.destinasi.size}")
                }

                override fun onError(e: Throwable) {
                    mView.hideLoading()
                    Log.d("ayam ", "${e.printStackTrace()}")
                    mView.displayDestinasi(Collections.emptyList())
                }
            })
        )
    }

    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }
}