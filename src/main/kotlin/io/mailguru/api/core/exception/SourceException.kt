package io.mailguru.api.core.exception

abstract class SourceException(
    override val message: String,
    open val parameter: String? = null,
    open val propertyPath: String? = null,
) : RuntimeException(message)