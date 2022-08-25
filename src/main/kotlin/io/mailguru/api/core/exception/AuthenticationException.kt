package io.mailguru.api.core.exception

class AuthenticationException(override val message: String = "Unauthorized") : RuntimeException()
