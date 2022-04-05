package com.example.account.application.service

import com.example.account.application.port.`in`.SignUpUseCase
import com.example.account.application.port.`in`.SignUpUseCase.SignUpRequestCommand
import com.example.account.application.port.out.CheckAccountExistsPort
import com.example.account.application.port.out.SaveAccountPort
import com.example.account.domain.Account
import com.example.account.exception.IdDuplicatedException
import org.springframework.stereotype.Service

@Service
class SignUpService(val checkAccountExistsPort: CheckAccountExistsPort, val saveAccountPort: SaveAccountPort) :
    SignUpUseCase {

    override fun signUp(command: SignUpRequestCommand) {
        if (checkAccountExistsPort.accountExists(command.accountId))
            throw IdDuplicatedException("${command.accountId}는 이미 존재하는 사용자입니다.")

        val account = command.run {
            Account(
                accountId = accountId,
                name = name,
                email = email,
                permission = permission,
            )
        }

        account.encryptPassword(command.password)
        saveAccountPort.saveAccount(account)
    }

}