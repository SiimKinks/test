package com.test.business.account

import com.test.CustomerId
import java.math.BigDecimal

typealias AccountId = String
typealias Iban = String

sealed interface Account : AccountInfo {
  val accountId: AccountId
  val customerId: CustomerId
  val isDefault: Boolean
  val balanceCount: Int
  val isPaymentAllowed: Boolean

  data class CurrentAccount(
    override val accountId: AccountId,
    override val customerId: CustomerId,
    override val iban: Iban,
    override val alias: String?,
    override val isDefault: Boolean,
    override val balanceCount: Int,
    override val isPaymentAllowed: Boolean
  ) : Account

  data class SavingsAccount(
    override val accountId: AccountId,
    override val customerId: CustomerId,
    override val iban: Iban,
    override val alias: String?,
    override val isDefault: Boolean,
    override val balanceCount: Int,
    override val isPaymentAllowed: Boolean,
    val goal: SavingsGoal?,
    val isRoundupEnabled: Boolean
  ) : Account {
    override val name: String
      get() = goal?.description ?: alias ?: iban
  }
}

data class SavingsGoal(
  val description: String?,
  val amount: BigDecimal?
)