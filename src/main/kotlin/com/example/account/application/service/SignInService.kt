package com.example.account.application.service

import com.example.account.application.port.`in`.SignInUseCase
import com.example.account.application.port.`in`.SignInUseCase.SignInRequestCommand
import com.example.account.application.port.out.LoadAccountPort
import com.example.account.exception.AccountNotFoundException
import com.example.account.exception.PasswordInvalidException
import org.springframework.stereotype.Service

@Service
class SignInService(val loadAccountPort: LoadAccountPort) : SignInUseCase {

    override fun signIn(command: SignInRequestCommand) {
        try {
            val findAccount = loadAccountPort.loadAccount(command.accountId)
            if (findAccount.checkPassword(command.password))
                throw PasswordInvalidException("잘못된 패스워드입니다.")
        } catch (e: NoSuchElementException) {
            throw AccountNotFoundException("${command.accountId}는 존재하지 않는 사용자입니다.")
        }
    }

}