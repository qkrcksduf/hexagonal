package com.example.account.apapter.out.persistence.entity

import com.example.account.domain.Account
import com.example.account.domain.AccountPermission
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "account")
data class AccountEntity(
    @Id
    val accountId: String,
    val name: String,
    val email: String,
    val password: String,
    val permission: AccountPermission
) {
    companion object {
        fun from(account: Account): AccountEntity {
            return account.run {
                AccountEntity(
                    accountId = accountId,
                    name = name,
                    email = email,
                    password = password,
                    permission = permission
                )
            }
        }
    }

    fun toDomain(): Account = Account(
        accountId = accountId,
        name = name,
        email = email,
        password = password,
        permission = permission
    )
}
