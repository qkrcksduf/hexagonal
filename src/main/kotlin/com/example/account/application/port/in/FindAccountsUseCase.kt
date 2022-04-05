package com.example.account.application.port.`in`

import com.example.account.application.port.`in`.FindAccountUseCase.FindAccountResponseQuery

interface FindAccountsUseCase {

    fun findAccounts(): List<FindAccountResponseQuery>

}