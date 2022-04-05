package com.example.account.apapter.out.persistence

import com.example.account.apapter.out.persistence.entity.AccountEntity
import com.example.account.application.port.out.CheckAccountExistsPort
import com.example.account.application.port.out.LoadAccountPort
import com.example.account.application.port.out.LoadAccountsPort
import com.example.account.application.port.out.SaveAccountPort
import com.example.account.domain.Account
import org.springframework.stereotype.Component

@Component
class AccountPersistenceAdapter(val accountRepository: AccountRepository) :
    CheckAccountExistsPort,
    SaveAccountPort,
    LoadAccountPort,
    LoadAccountsPort {

    override fun accountExists(accountId: String): Boolean {
        if (accountRepository.findById(accountId).isEmpty) {
            return false
        }
        return true
    }

    override fun saveAccount(account: Account): Account {
        return accountRepository.save(AccountEntity.from(account)).toDomain()
    }

    override fun loadAccount(accountId: String): Account {
        return accountRepository.findById(accountId).orElseThrow().toDomain()
    }

    override fun loadAccounts(): List<Account> {
        return accountRepository.findAll().map { it.toDomain() }
    }

}