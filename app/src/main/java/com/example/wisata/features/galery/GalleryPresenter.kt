package com.example.wisata.features.galery

import android.util.Log
import com.example.wisata.features.event.EventContract
import com.example.wisata.repositories.EventRepositoryImp
import com.example.wisata.repositories.GalleryRepositoryImp
import com.example.wisata.responses.EventResponse
import com.example.wisata.responses.GalleryResponse
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*


class GalleryPresenter(
    val mView: GalleryContract.View,
    private val galleryRepositoryImp: GalleryRepositoryImp,
    private val schedule: SchedulerProvider
) : GalleryContract.Presenter {
    private val compositeDisposable = CompositeDisposable()
    override fun getGalleryData() {
        mView.showLoading()
        compositeDisposable.add(galleryRepositoryImp.getGallery()
            .observeOn(schedule.ui())
            .subscribeOn(schedule.io())
            .subscribeWith(object : ResourceSubscriber<GalleryResponse>(){
                override fun onComplete() {
                    mView.hideLoading()
                }

                override fun onNext(t: GalleryResponse) {
                    mView.displayGallery(t.gallery)
                }

                override fun onError(e: Throwable) {
                    mView.hideLoading()
                    Log.d("ayam ", "${e.printStackTrace()}")
                    mView.displayGallery(Collections.emptyList())
                }
            })
        )
    }

    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }
}