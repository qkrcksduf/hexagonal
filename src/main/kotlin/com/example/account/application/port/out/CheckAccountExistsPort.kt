package com.example.account.application.port.out

interface CheckAccountExistsPort {

    fun accountExists(accountId: String): Boolean

}