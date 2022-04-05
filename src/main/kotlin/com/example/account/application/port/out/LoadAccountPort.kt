package com.example.account.application.port.out

import com.example.account.domain.Account

interface LoadAccountPort {

    @Throws(NoSuchElementException::class)
    fun loadAccount(accountId: String): Account

}