package com.test.business.account

import android.net.Uri
import io.reactivex.Observable

interface SavingsRepository {
  fun observeSavingsAccountImages(accountIds: List<AccountId>): Observable<Map<AccountId, Uri>>
}