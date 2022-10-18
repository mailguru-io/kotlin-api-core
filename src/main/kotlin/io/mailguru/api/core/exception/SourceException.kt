package io.mailguru.api.core.exception

abstract class SourceException(
    message: String,
    cause: Throwable? = null,
    open val parameter: String? = null,
    open val propertyPath: String? = null,
) : RuntimeException(message, cause)
