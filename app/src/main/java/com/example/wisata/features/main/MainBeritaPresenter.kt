package com.example.wisata.features.main

import android.util.Log
import com.example.wisata.features.destinasi.DestinasiContract
import com.example.wisata.models.Berita
import com.example.wisata.repositories.BeritaRepositoryImp
import com.example.wisata.repositories.DestinasiRepositoryImp
import com.example.wisata.repositories.EventRepositoryImp
import com.example.wisata.responses.BeritaResponse
import com.example.wisata.responses.DestinasiResponse
import com.example.wisata.responses.EventResponse
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*


class MainBeritaPresenter(
    val mView: MainBeritaContract.View,
    private val beritaRepositoryImp: BeritaRepositoryImp,
    private val schedule: SchedulerProvider
) : MainBeritaContract.Presenter {
    private val compositeDisposable = CompositeDisposable()
    override fun getBeritaData() {
        mView.showLoading()
        compositeDisposable.add(beritaRepositoryImp.getBerita()
            .observeOn(schedule.ui())
            .subscribeOn(schedule.io())
            .subscribeWith(object : ResourceSubscriber<BeritaResponse>(){
                override fun onComplete() {
                    mView.hideLoading()
                }

                override fun onNext(t: BeritaResponse) {
                    mView.displayBerita(t.berita)
                }

                override fun onError(e: Throwable) {
                    mView.hideLoading()
                    Log.d("ayam ", "${e.printStackTrace()}")
                    mView.displayBerita(Collections.emptyList())
                }
            })
        )
    }

    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }
}