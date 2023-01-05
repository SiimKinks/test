package com.test.business.account

interface AccountInfo {
  val iban: Iban
  val alias: String?
  val name: String
    get() = alias ?: iban
}