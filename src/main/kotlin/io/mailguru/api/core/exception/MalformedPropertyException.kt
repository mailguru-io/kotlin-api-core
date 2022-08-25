package io.mailguru.api.core.exception

class MalformedPropertyException(
    override val message: String = "Malformed property.",
    override val propertyPath: String,
) : SourceException(message, propertyPath = propertyPath)
