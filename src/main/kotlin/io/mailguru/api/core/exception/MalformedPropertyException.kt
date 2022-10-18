package io.mailguru.api.core.exception

class MalformedPropertyException(
    message: String? = null,
    cause: Throwable? = null,
    propertyPath: String? = null,
) : SourceException(message ?: "Malformed property.", cause, null, propertyPath)
