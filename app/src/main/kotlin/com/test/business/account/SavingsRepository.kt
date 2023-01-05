package com.test.business.account

import android.net.Uri
import androidx.annotation.Size
import io.reactivex.Observable

interface SavingsRepository {
  fun observeSavingsAccountImages(@Size(min = 1) accountIds: List<AccountId>): Observable<Map<AccountId, Uri>>
}