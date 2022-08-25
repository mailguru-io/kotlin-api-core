package io.mailguru.api.core.exception

class ResourceNotFoundException(
    override val message: String = "The requested resource could not be found.",
    override val parameter: String? = null,
    override val propertyPath: String? = null
) : SourceException(message, parameter = parameter, propertyPath = propertyPath)
