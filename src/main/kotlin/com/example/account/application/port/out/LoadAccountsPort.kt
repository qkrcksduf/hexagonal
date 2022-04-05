package com.example.account.application.port.out

import com.example.account.domain.Account

interface LoadAccountsPort {

    fun loadAccounts(): List<Account>

}