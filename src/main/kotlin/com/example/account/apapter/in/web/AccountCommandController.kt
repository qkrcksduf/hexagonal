package com.example.account.apapter.`in`.web

import com.example.account.application.port.`in`.SignInUseCase
import com.example.account.application.port.`in`.SignInUseCase.SignInRequestCommand
import com.example.account.application.port.`in`.SignUpUseCase
import com.example.account.application.port.`in`.SignUpUseCase.SignUpRequestCommand
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class AccountCommandController(val signUpUseCase: SignUpUseCase, val signInUseCase: SignInUseCase) {

    @PostMapping("/signUp")
    fun signUp(@RequestBody @Valid command: SignUpRequestCommand): ResponseEntity<HttpStatus> {
        signUpUseCase.signUp(command)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PostMapping("/signIn")
    fun signIn(@RequestBody @Valid command: SignInRequestCommand): ResponseEntity<HttpStatus> {
        signInUseCase.signIn(command)
        return ResponseEntity(HttpStatus.CREATED)
    }

}