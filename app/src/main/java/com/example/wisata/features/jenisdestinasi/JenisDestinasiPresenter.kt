package com.example.wisata.features.jenisdestinasi

import android.util.Log
import com.example.wisata.repositories.JenisDestinasiRepositoryImp
import com.example.wisata.responses.JenisDestinasiResponse
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class JenisDestinasiPresenter(
    val mView:JenisDestinasiContract.View,
    private val jenisDestinasiRepositoryImp: JenisDestinasiRepositoryImp,
    private val schedule:SchedulerProvider
) : JenisDestinasiContract.Presenter{
    private val compositeDisposable = CompositeDisposable()
    override fun getJenisDestinasiData() {
        mView.showLoading()
        //print("halo error")
        compositeDisposable.add(jenisDestinasiRepositoryImp.getJenisDestinasi()
            .observeOn(schedule.ui())
            .subscribeOn(schedule.io())
            .subscribeWith(object : ResourceSubscriber<JenisDestinasiResponse>(){
                override fun onComplete() {
                    mView.hideLoading()
                }

                override fun onNext(t: JenisDestinasiResponse) {
                    Log.d("ayam ", "${t.jenis_destinasi}")
                    mView.displayJenisDestinasi(t.jenis_destinasi)
                }

                override fun onError(e: Throwable) {
                    mView.hideLoading()
                    mView.displayJenisDestinasi(Collections.emptyList())
                }
            })
        )
    }

    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }
}