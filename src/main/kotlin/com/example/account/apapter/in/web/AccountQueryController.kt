package com.example.account.apapter.`in`.web

import com.example.account.application.port.`in`.FindAccountUseCase
import com.example.account.application.port.`in`.FindAccountUseCase.FindAccountResponseQuery
import com.example.account.application.port.`in`.FindAccountsUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountQueryController(val findAccountUseCase: FindAccountUseCase, val findAccountsUseCase: FindAccountsUseCase) {

    @GetMapping("/accounts/{account-id}")
    fun findAccount(@PathVariable("account-id") accountId: String): ResponseEntity<FindAccountResponseQuery> {
        return ResponseEntity.status(HttpStatus.OK).body(findAccountUseCase.findAccount(accountId))
    }

    @GetMapping("/accounts")
    fun findAccounts(): ResponseEntity<List<FindAccountResponseQuery>> {
        return ResponseEntity.status(HttpStatus.OK).body(findAccountsUseCase.findAccounts())
    }

}