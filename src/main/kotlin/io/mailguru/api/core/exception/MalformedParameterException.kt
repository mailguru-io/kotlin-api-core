package io.mailguru.api.core.exception

class MalformedParameterException(
    message: String? = null,
    cause: Throwable? = null,
    parameter: String? = null,
) : SourceException(message ?: "Malformed parameter.", cause, parameter, null)
