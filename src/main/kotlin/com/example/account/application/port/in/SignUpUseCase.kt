package com.example.account.application.port.`in`

import com.example.account.domain.AccountPermission
import javax.validation.constraints.NotBlank

interface SignUpUseCase {

    fun signUp(command: SignUpRequestCommand)

    data class SignUpRequestCommand(
        @field:NotBlank
        val accountId: String,

        @field:NotBlank
        val name: String,

        @field:NotBlank
        val email: String,

        val permission: AccountPermission,

        @field:NotBlank
        val password: String
    )

}