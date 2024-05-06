package com.test.presentation.internal

import io.reactivex.Observable
import io.reactivex.disposables.Disposables
import io.reactivex.subjects.BehaviorSubject

abstract class Presenter<View : ViewStateRenderer<ViewState>, ViewState> {
  private val viewStates = BehaviorSubject.create<ViewState>()
  private var viewStateDisposable = Disposables.disposed()
  private var isActive = false

  abstract fun bindActions()

  fun attachView(view: View) {
    viewStateDisposable = viewStates.subscribe(view::render)
  }

  fun detachView() {
    viewStateDisposable.dispose()
  }

  private fun subscribeViewState(viewStateObservable: Observable<ViewState>) {
    check(!isActive) {
      "subscribeViewState() is only allowed to be called once"
    }
    isActive = true

    viewStateObservable.subscribe(viewStates)
  }

  @JvmName("_subscribeViewState")
  protected fun Observable<ViewState>.subscribeViewState() = subscribeViewState(this)
}
