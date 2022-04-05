package com.example.account.exception.handler

import org.springframework.http.HttpStatus

object ErrorMessageFactory {

    fun from(httpStatus: HttpStatus, message: String): ErrorMessage {
        return ErrorMessage(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message
        )
    }

}