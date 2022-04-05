package com.example.account.exception.handler

import com.example.account.exception.AccountNotFoundException
import com.example.account.exception.IdDuplicatedException
import com.example.account.exception.PasswordInvalidException
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidExceptionHandler(e: MethodArgumentNotValidException): ResponseEntity<ErrorMessage> {
        val status = BAD_REQUEST
        val errorMessage = ErrorMessageFactory.from(status, e.message)
        errorMessage.setMessage(e.bindingResult)

        return ResponseEntity.status(BAD_REQUEST).body(errorMessage)
    }

    @ExceptionHandler(AccountNotFoundException::class)
    fun accountNotFoundExceptionHandler(e: AccountNotFoundException): ResponseEntity<ErrorMessage> {
        val status = NOT_FOUND
        return ResponseEntity.status(status)
            .body(ErrorMessageFactory.from(status, e.message))
    }

    @ExceptionHandler(IdDuplicatedException::class)
    fun idDuplicatedExceptionHandler(e: IdDuplicatedException): ResponseEntity<ErrorMessage> {
        val status = BAD_REQUEST
        return ResponseEntity.status(status)
            .body(ErrorMessageFactory.from(status, e.message))
    }

    @ExceptionHandler(PasswordInvalidException::class)
    fun passwordInvalidExceptionHandler(e: PasswordInvalidException): ResponseEntity<ErrorMessage> {
        val status = BAD_REQUEST
        return ResponseEntity.status(status)
            .body(ErrorMessageFactory.from(status, e.message))
    }

}