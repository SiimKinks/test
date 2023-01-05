package com.test.business.account

import com.test.CustomerId
import io.reactivex.Observable

interface AccountRepository {
  fun observeAllAccounts(customerId: CustomerId): Observable<List<Account>>
}