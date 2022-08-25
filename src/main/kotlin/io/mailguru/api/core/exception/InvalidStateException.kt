package io.mailguru.api.core.exception

class InvalidStateException(
    message: String?,
    override val parameter: String? = null,
    override val propertyPath: String? = null,
) : SourceException(message ?: "Invalid state.", parameter = parameter, propertyPath = propertyPath)
