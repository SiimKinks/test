package com.test.business.customer

typealias CustomerId = String

data class Customer(
  val id: CustomerId,
  val name: String
)