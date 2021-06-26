package com.example.wisata.features.destinasi

import android.util.Log
import com.example.wisata.features.jenisdestinasi.JenisDestinasiContract
import com.example.wisata.repositories.DestinasiMapRepositoryImp
import com.example.wisata.repositories.DestinasiRepositoryImp
import com.example.wisata.repositories.JenisDestinasiRepositoryImp
import com.example.wisata.responses.DestinasiResponse
import com.example.wisata.responses.JenisDestinasiResponse
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*


class DestinasiMapPresenter(
    val mView: DestinasiMapContract.View,
    private val destinasiMapRepositoryImp: DestinasiMapRepositoryImp,
    private val schedule: SchedulerProvider
) : DestinasiMapContract.Presenter{
    private val compositeDisposable = CompositeDisposable()
    override fun getDestinasiMapData() {
        compositeDisposable.add(destinasiMapRepositoryImp.getDestinasiMap()
            .observeOn(schedule.ui())
            .subscribeOn(schedule.io())
            .subscribeWith(object : ResourceSubscriber<DestinasiResponse>(){
                override fun onComplete() {
                }

                override fun onNext(t: DestinasiResponse) {
                    mView.displayDestinasi(t.destinasi)
                    Log.d("ayam ", "${t.destinasi.size}")

                }

                override fun onError(e: Throwable) {
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