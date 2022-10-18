package io.mailguru.api.core.exception

class AuthenticationException(
    message: String = "Unauthorized",
    cause: Throwable? = null,
) : RuntimeException(message, cause)
