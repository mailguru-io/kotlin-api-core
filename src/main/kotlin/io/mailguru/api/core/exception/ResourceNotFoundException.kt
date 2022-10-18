package io.mailguru.api.core.exception

class ResourceNotFoundException(
    message: String? = null,
    cause: Throwable? = null,
    parameter: String? = null,
    propertyPath: String? = null,
) : SourceException(message ?: "The requested resource could not be found.", cause, parameter, propertyPath)
