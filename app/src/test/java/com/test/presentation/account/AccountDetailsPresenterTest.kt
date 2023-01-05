package com.test.presentation.account

import com.test.presentation.internal.test
import org.junit.Test

class AccountDetailsPresenterTest {
  private val presenter = AccountDetailsPresenter()

  @Test
  fun startsWithInitialViewState() {
    presenter.test {
      produces(AccountDetailsViewState)
    }
  }
}