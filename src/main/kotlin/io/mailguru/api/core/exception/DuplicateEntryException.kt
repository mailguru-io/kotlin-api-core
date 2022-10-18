package io.mailguru.api.core.exception

class DuplicateEntryException(
    message: String? = null,
    cause: Throwable? = null,
    parameter: String? = null,
    propertyPath: String? = null,
) : SourceException(message ?: "Duplicate entry.", cause, parameter, propertyPath)
