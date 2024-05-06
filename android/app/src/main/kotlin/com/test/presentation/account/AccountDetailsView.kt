package com.test.presentation.account

import com.test.presentation.internal.ViewStateRenderer

class AccountDetailsView : ViewStateRenderer<AccountDetailsViewState> {
  val seenViewStates = mutableListOf<AccountDetailsViewState>()

  override fun render(viewState: AccountDetailsViewState) {
    seenViewStates.add(viewState)
  }
}