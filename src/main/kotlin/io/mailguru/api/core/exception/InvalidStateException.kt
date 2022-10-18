package io.mailguru.api.core.exception

class InvalidStateException(
    message: String? = null,
    cause: Throwable? = null,
    parameter: String? = null,
    propertyPath: String? = null,
) : SourceException(message ?: "Invalid state.", cause, parameter, propertyPath)
