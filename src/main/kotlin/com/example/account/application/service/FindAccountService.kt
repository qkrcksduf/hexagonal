package com.example.account.application.service

import com.example.account.application.port.`in`.FindAccountUseCase
import com.example.account.application.port.`in`.FindAccountUseCase.FindAccountResponseQuery
import com.example.account.application.port.out.LoadAccountPort
import com.example.account.exception.AccountNotFoundException
import org.springframework.stereotype.Service

@Service
class FindAccountService(val loadAccountPort: LoadAccountPort) : FindAccountUseCase {

    override fun findAccount(accountId: String): FindAccountResponseQuery {
        try {
            val findAccount = loadAccountPort.loadAccount(accountId)
            return findAccount.run {
                FindAccountResponseQuery(
                    accountId = accountId,
                    name = name,
                    permission = permission,
                    email = email
                )
            }
        } catch (e: NoSuchElementException) {
            throw AccountNotFoundException("${accountId}는 존재하지 않는 사용자입니다.")
        }
    }

}