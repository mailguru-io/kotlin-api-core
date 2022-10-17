package io.mailguru.api.core.exception

class UnavailableForLegalReasonsException(
    message: String? = null,
    cause: Throwable? = null,
    parameter: String? = null,
    propertyPath: String? = null,
) : SourceException(
    message ?: "The requested resource is unavailable for legal reasons.",
    cause,
    parameter,
    propertyPath
)
