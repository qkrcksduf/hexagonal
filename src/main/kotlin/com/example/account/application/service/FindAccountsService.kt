package com.example.account.application.service

import com.example.account.application.port.`in`.FindAccountUseCase.FindAccountResponseQuery
import com.example.account.application.port.`in`.FindAccountsUseCase
import com.example.account.application.port.out.LoadAccountsPort
import org.springframework.stereotype.Service

@Service
class FindAccountsService(val loadAccountsPort: LoadAccountsPort) : FindAccountsUseCase {

    override fun findAccounts(): List<FindAccountResponseQuery> {
        return loadAccountsPort.loadAccounts()
            .map {
                FindAccountResponseQuery(
                    accountId = it.accountId,
                    name = it.name,
                    permission = it.permission,
                    email = it.email
                )
            }
    }

}