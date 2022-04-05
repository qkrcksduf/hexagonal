package com.example.account.application.port.`in`

import com.example.account.domain.AccountPermission

interface FindAccountUseCase {

    fun findAccount(accountId: String): FindAccountResponseQuery

    data class FindAccountResponseQuery(
        val accountId: String,
        val name: String,
        val permission: AccountPermission,
        val email: String
    )

}