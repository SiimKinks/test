package com.test.presentation.account

import com.test.presentation.internal.Presenter
import io.reactivex.Observable

class AccountDetailsPresenter(
) : Presenter<AccountDetailsView, AccountDetailsViewState>() {
  override fun bindActions() {
    Observable.just(AccountDetailsViewState)
      .subscribeViewState()
  }
}