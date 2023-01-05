package com.test.presentation.internal

import com.google.common.truth.Truth.assertWithMessage
import com.test.presentation.account.AccountDetailsPresenter
import com.test.presentation.account.AccountDetailsView
import com.test.presentation.account.AccountDetailsViewState

typealias View = AccountDetailsView
typealias ViewState = AccountDetailsViewState

fun AccountDetailsPresenter.test(block: PresenterAssertions.() -> Unit) {
  val assertions = PresenterAssertions()
  val view = View()
  attachView(view)
  bindActions()
  detachView()
  assertions.seenViewStates = view.seenViewStates
  assertions.block()
}

class PresenterAssertions {
  var seenViewStates: List<ViewState> = emptyList()

  fun producesNothing() {
    assertWithMessage("produced view state(s) ")
      .that(seenViewStates)
      .isEmpty()
  }

  fun produces(initialViewState: ViewState, vararg otherViewStates: ViewState) {
    assertWithMessage("produced view state(s) ")
      .that(seenViewStates)
      .isEqualTo(listOf(initialViewState, *otherViewStates))
  }

  fun produces(viewStateAssertions: (producedViewStates: List<ViewState>) -> Unit) {
    viewStateAssertions(seenViewStates)
  }
}
