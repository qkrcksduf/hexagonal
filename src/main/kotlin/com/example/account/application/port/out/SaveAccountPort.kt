package com.example.account.application.port.out

import com.example.account.domain.Account

interface SaveAccountPort {

    fun saveAccount(account: Account): Account

}