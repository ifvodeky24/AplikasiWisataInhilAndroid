package com.example.wisata.features.event

import android.util.Log
import com.example.wisata.features.event.EventContract
import com.example.wisata.repositories.EventRepositoryImp
import com.example.wisata.responses.EventResponse
import com.rahmat.app.footballclub.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*


class EventPresenter(
    val mView: EventContract.View,
    val eventRepositoryImp: EventRepositoryImp,
    val schedule: SchedulerProvider
) : EventContract.Presenter {
    val compositeDisposable = CompositeDisposable()
    override fun getEventData() {
        mView.showLoading()
        compositeDisposable.add(eventRepositoryImp.getEvent()
            .observeOn(schedule.ui())
            .subscribeOn(schedule.io())
            .subscribeWith(object : ResourceSubscriber<EventResponse>(){
                override fun onComplete() {
                    mView.hideLoading()
                }

                override fun onNext(t: EventResponse) {
                    mView.displayEvent(t.event)
                }

                override fun onError(e: Throwable) {
                    mView.hideLoading()
                    Log.d("ayam ", "${e.printStackTrace()}")
                    mView.displayEvent(Collections.emptyList())
                }
            })
        )
    }

    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }
}