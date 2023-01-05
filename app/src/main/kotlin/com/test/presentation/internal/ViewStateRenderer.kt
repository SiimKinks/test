package com.test.presentation.internal

interface ViewStateRenderer<in ViewState> {
  fun render(viewState: ViewState)
}